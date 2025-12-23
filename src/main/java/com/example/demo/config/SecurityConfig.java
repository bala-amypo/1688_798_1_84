package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            // ❌ Disable CSRF for REST APIs
            .csrf(csrf -> csrf.disable())

            // ❌ Disable default login form
            .formLogin(form -> form.disable())

            // ❌ Disable HTTP Basic auth
            .httpBasic(basic -> basic.disable())

            // ✅ Allow Swagger + APIs
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/v3/api-docs/**",
                    "/swagger-ui/**",
                    "/swagger-ui.html",
                    "/api/**"
                ).permitAll()
                .anyRequest().authenticated()
            );

        return http.build();
    }
}
