package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI vehicleServiceAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Vehicle Service History API")
                        .description("API for managing vehicle service history")
                        .version("1.0"));
    }
}