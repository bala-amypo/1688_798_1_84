package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    // 🔐 Secret key (must be >= 256 bits for HS256)
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // ⏰ Token validity (1 day)
    private final long EXPIRATION_TIME = 24 * 60 * 60 * 1000;

    // ✅ GENERATE TOKEN (MATCHES AuthController)
    public String generateToken(String username, String role, Long userId) {

        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)     // ROLE_USER / ROLE_ADMIN
                .claim("userId", userId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }

    // ✅ VALIDATE TOKEN
    public boolean validateToken(String token) {
        try {
            getClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // ✅ GET USERNAME (USED BY FILTER)
    public String getSubject(String token) {
        return getClaims(token).getSubject();
    }

    // ✅ GET ROLE (USED BY FILTER)
    public String getRole(String token) {
        return getClaims(token).get("role", String.class);
    }

    // 🔒 INTERNAL: READ CLAIMS
    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
