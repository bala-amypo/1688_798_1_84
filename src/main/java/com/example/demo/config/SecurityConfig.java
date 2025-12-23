// package com.example.demo.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// public class SecurityConfig {

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//         http
//             // ✅ Disable CSRF (important for Swagger POST)
//             .csrf(csrf -> csrf.disable())

//             // ✅ Stateless (no sessions)
//             .sessionManagement(session ->
//                 session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//             )

//             // ✅ Authorization rules
//             .authorizeHttpRequests(auth -> auth

//                 // ✅ Swagger allowed
//                 .requestMatchers(
//                         "/v3/api-docs/**",
//                         "/swagger-ui/**",
//                         "/swagger-ui.html"
//                 ).permitAll()

//                 // ✅ Auth APIs allowed
//                 .requestMatchers("/api/auth/**").permitAll()

//                 // ✅ IMPORTANT: Allow Garage APIs (FIX FOR 403)
//                 .requestMatchers("/garages/**").permitAll()

//                 // 🔐 Everything else requires auth
//                 .anyRequest().authenticated()
//             );

//         return http.build();
//     }

//     @Bean
//     public AuthenticationManager authenticationManager(
//             AuthenticationConfiguration configuration) throws Exception {
//         return configuration.getAuthenticationManager();
//     }
// }

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            // Disable CSRF for REST APIs
            .csrf(csrf -> csrf.disable())

            // Stateless API
            .sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )

            .authorizeHttpRequests(auth -> auth

                // Swagger
                .requestMatchers(
                        "/v3/api-docs/**",
                        "/swagger-ui/**",
                        "/swagger-ui.html"
                ).permitAll()

                // Auth APIs
                .requestMatchers("/api/auth/**").permitAll()

                // ✅ FIX: Vehicles API
                .requestMatchers("/api/vehicles/**").permitAll()

                // Everything else secured
                .anyRequest().authenticated()
            );

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}
