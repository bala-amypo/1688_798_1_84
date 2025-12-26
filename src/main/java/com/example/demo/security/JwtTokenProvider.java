package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    private final Key key = Keys.hmacShaKeyFor(
            "mysecretkeymysecretkeymysecretkey".getBytes()
    );

    private final long jwtExpirationMs = 86400000;

    // REQUIRED BY TESTS
    public String generateToken(String username, String role, Long userId) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + jwtExpirationMs);

        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .claim("userId", userId)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // Keep this if used elsewhere
    public String generateToken(String username) {
        return generateToken(username, "USER", 0L);
    }
}
