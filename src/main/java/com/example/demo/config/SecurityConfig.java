@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    http
        .csrf(csrf -> csrf.disable())
        .sessionManagement(session ->
            session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        )
        .authorizeHttpRequests(auth -> auth

            // ✅ Swagger
            .requestMatchers(
                "/v3/api-docs/**",
                "/swagger-ui/**",
                "/swagger-ui.html"
            ).permitAll()

            // ✅ Auth
            .requestMatchers("/api/auth/**").permitAll()

            // ✅ ALLOW GARAGE API (FIX)
            .requestMatchers("/garages/**").permitAll()

            // 🔐 Others
            .anyRequest().authenticated()
        );

    return http.build();
}
