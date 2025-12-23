// package com.example.demo.security;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import io.jsonwebtoken.security.Keys;
// import org.springframework.stereotype.Component;

// import java.util.Date;

// @Component
// public class JwtTokenProvider {

//     private static final String SECRET_KEY =
//             "mysecretkeymysecretkeymysecretkey12345";

//     private static final long EXPIRATION = 86400000; // 1 day

//     public String generateToken(String username) {
//         return Jwts.builder()
//                 .setSubject(username)
//                 .claim("role", "ROLE_USER")
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
//                 .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()),
//                         SignatureAlgorithm.HS256)
//                 .compact();
//     }
//     @Override
//     protected boolean shouldNotFilter(HttpServletRequest request) {
//         String path = request.getServletPath();

//         return path.startsWith("/swagger-ui")
//             || path.startsWith("/v3/api-docs")
//             || path.startsWith("/swagger-ui.html")
//             || path.startsWith("/api/auth");
//     }

//     public String getUsername(String token) {
//         return getClaims(token).getSubject();
//     }

//     public String getRole(String token) {
//         return getClaims(token).get("role", String.class);
//     }

//     public boolean validateToken(String token) {
//         try {
//             getClaims(token);
//             return true;
//         } catch (Exception e) {
//             return false;
//         }
//     }

//     private Claims getClaims(String token) {
//         return Jwts.parserBuilder()
//                 .setSigningKey(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
//                 .build()
//                 .parseClaimsJws(token)
//                 .getBody();
//     }
// }

package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    private final String SECRET_KEY = "my-secret-key-my-secret-key-my-secret-key"; // min 32 chars
    private final long EXPIRATION_TIME = 86400000; // 1 day

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    // ✅ Generate token
    public String generateToken(String username, String role) {
        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getSigningKey())
                .compact();
    }

    // ✅ Validate token
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // ✅ Extract username
    public String getUsername(String token) {
        return getClaims(token).getSubject();
    }

    // ✅ Extract role
    public String getRole(String token) {
        return getClaims(token).get("role", String.class);
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
