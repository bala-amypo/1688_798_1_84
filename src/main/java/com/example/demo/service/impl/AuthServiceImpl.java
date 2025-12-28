// package com.example.demo.service.impl;

// import com.example.demo.model.AppUser;
// import com.example.demo.repository.AppUserRepository;
// import com.example.demo.security.JwtTokenProvider;
// import com.example.demo.service.AuthService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;

// @Service
// public class AuthServiceImpl implements AuthService {
    
//     @Autowired
//     private AppUserRepository userRepository;
    
//     @Autowired
//     private PasswordEncoder passwordEncoder;
    
//     @Autowired
//     private JwtTokenProvider jwtTokenProvider;

//     @Override
//     public AppUser register(AppUser user) {
//         user.setPassword(passwordEncoder.encode(user.getPassword()));
//         return userRepository.save(user);
//     }

//     @Override
//     public String authenticate(String email, String password) {
//         AppUser user = userRepository.findByEmail(email)
//                 .orElseThrow(() -> new IllegalArgumentException("Invalid credentials"));
        
//         if (passwordEncoder.matches(password, user.getPassword())) {
//             return jwtTokenProvider.generateToken(user.getEmail(), user.getRole(), user.getId());
//         }
//         throw new IllegalArgumentException("Invalid credentials");
//     }
// }

package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.AppUser;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final AppUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthServiceImpl(AppUserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public AuthResponse login(AuthRequest request) {
        AppUser user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid credentials"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Invalid credentials");
        }

        String token = jwtTokenProvider.generateToken(
                user.getEmail(), user.getRole(), user.getId());

        return new AuthResponse(token);
    }

    @Override
    public void register(RegisterRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already registered");
        }

        AppUser user = new AppUser();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole("USER");

        userRepository.save(user);
    }
}
