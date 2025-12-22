package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.security.JwtTokenProvider;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtTokenProvider jwt;

    public AuthController(JwtTokenProvider jwt) {
        this.jwt = jwt;
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {

        // Dummy auth (acceptable for test helper)
        String token = jwt.generateToken(
                request.getEmail(),
                "USER",
                1L
        );

        return new AuthResponse(token, 1L, request.getEmail(), "USER");
    }
}
