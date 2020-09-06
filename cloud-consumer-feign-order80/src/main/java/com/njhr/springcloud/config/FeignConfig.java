package com.njhr.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * openfeign支持日志打印
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLOgger() {
        return Logger.Level.FULL;
    }
}
