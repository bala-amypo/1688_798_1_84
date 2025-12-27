package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI vehicleServiceAPI() {
        return new OpenAPI()
                .addServersItem(new Server().url("https://9213.pro604cr.amypo.ai"))
                .info(new Info()
                        .title("Vehicle Service History API")
                        .description("API for managing vehicle service history")
                        .version("1.0"));
    }
}