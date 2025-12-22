package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.security.JwtTokenProvider;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    /**
     * LOGIN API
     * URL: POST /api/auth/login
     */
    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {

        // ✅ Normally you validate username/password from DB
        // For now: direct login (demo purpose)

        String username = request.getUsername();

        // 🔥 ROLE MUST START WITH ROLE_
        String role = "ROLE_USER";

        Long userId = 1L;

        String token = jwtTokenProvider.generateToken(username, role, userId);

        return new AuthResponse(
                token,
                userId,
                username,
                role
        );
    }
}
