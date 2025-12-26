package com.example.demo.controller;

import com.example.demo.dto.AuthRequestDto;
import com.example.demo.security.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequestDto request) {

        // Dummy authentication (replace with DB/user-service later)
        if ("admin".equals(request.getUsername()) &&
            "password".equals(request.getPassword())) {

            String token = jwtTokenProvider.generateToken(request.getUsername());
            return ResponseEntity.ok(token);
        }

        return ResponseEntity.status(401).body("Invalid credentials");
    }
}
