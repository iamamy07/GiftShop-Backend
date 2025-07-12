package com.example.spring_boot_ecommerce.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyAppConfig implements WebMvcConfigurer {
    @Value("${allowed.origins}")
    private String[] theAllowedOrigins;

    @Value("${spring.data.rest.base-path}")
    private String basePath;
    public void addCorsMappings(CorsRegistry cors)
    {
        cors.addMapping(basePath + "/**")
            .allowedOrigins(theAllowedOrigins)
                .allowedHeaders("*")  // <-- Allows Authorization, Content-Type, etc.
                .allowCredentials(true);
    }

}
