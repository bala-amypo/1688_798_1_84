// package com.example.demo.security;

// public class SecurityConstants {
//     public static final String JWT_SECRET = "mySecretKey";
//     public static final long JWT_EXPIRATION = 86400000L; // 24 hours
//     public static final String JWT_HEADER = "Authorization";
//     public static final String JWT_PREFIX = "Bearer ";
// }

package com.example.demo.security;

public final class SecurityConstants {

    private SecurityConstants() {
        // prevent instantiation
    }

    // ===============================
    // JWT CONSTANTS
    // ===============================

    public static final String SECRET_KEY =
            "mysecretkeymysecretkeymysecretkeymysecretkey";

    public static final long EXPIRATION_TIME =
            24 * 60 * 60 * 1000; // 1 day in milliseconds

    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";

    // ===============================
    // PUBLIC ENDPOINTS
    // ===============================

    public static final String[] PUBLIC_URLS = {
            "/api/auth/**",
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/swagger-ui.html",
            "/h2-console/**"
    };
}
