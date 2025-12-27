package com.example.demo.config;

import com.example.demo.servlet.SimpleHealthServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig {

    @Bean
    public ServletRegistrationBean<SimpleHealthServlet> healthServletRegistration() {
        ServletRegistrationBean<SimpleHealthServlet> registration = new ServletRegistrationBean<>();
        registration.setServlet(new SimpleHealthServlet());
        registration.addUrlMappings("/health");
        return registration;
    }
}