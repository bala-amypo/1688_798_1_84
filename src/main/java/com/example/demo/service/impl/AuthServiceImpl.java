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