package com.example.inventoryservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Allow CORS for all endpoints (you can adjust this as needed)
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8000")  // Replace with your frontend URL if needed
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH")  // Specify allowed HTTP methods
                .allowedHeaders("*")  // Allow all headers
                .allowCredentials(true);  // Allow credentials like cookies, authorization headers
    }
}
