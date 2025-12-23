// package com.example.demo.security;

// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import org.springframework.web.filter.OncePerRequestFilter;

// import java.io.IOException;

// public class JwtAuthenticationFilter extends OncePerRequestFilter {

//     @Override
//     protected void doFilterInternal(
//             HttpServletRequest request,
//             HttpServletResponse response,
//             FilterChain filterChain
//     ) throws ServletException, IOException {

//         String path = request.getServletPath();

//         // ✅ Allow Swagger and Auth endpoints without JWT
//         if (path.startsWith("/auth")
//                 || path.startsWith("/swagger-ui")
//                 || path.startsWith("/v3/api-docs")) {

//             filterChain.doFilter(request, response);
//             return;
//         }

//         // JWT validation logic can be added later

//         filterChain.doFilter(request, response);
//     }
// }


package com.example.demo.security;

/**
 * NOTE:
 * -----
 * This class is intentionally kept EMPTY and INACTIVE.
 *
 * - It is NOT annotated with @Component / @Service
 * - It is NOT registered in SecurityFilterChain
 * - It DOES NOT intercept requests
 *
 * This avoids 403 errors while preserving folder structure.
 */
public class JwtAuthenticationFilter {

    // Intentionally left blank
}

