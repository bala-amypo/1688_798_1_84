// package com.example.demo.service;

// import com.example.demo.model.AppUser;

// public interface AuthService {
//     AppUser register(AppUser user);
//     String authenticate(String email, String password);
// }

package com.example.demo.service;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;

public interface AuthService {
    AuthResponse login(AuthRequest request);
    void register(RegisterRequest request);
}
