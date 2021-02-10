package com.njhr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppliactionContextConfig {
    @Bean
    public RestTemplate getrestTemplate() {
        return new RestTemplate();
    }
}
