package com.example.orderservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Allow cross-origin requests from localhost:3000 (frontend)
        registry.addMapping("/**")  // Apply to all endpoints
                .allowedOrigins("http://localhost:8000")  // Allow requests from the frontend at localhost:3000
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH")  // Allow these HTTP methods
                .allowedHeaders("*")  // Allow all headers
                .allowCredentials(true);  // Allow credentials such as cookies
    }
}
