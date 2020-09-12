package com.njhr.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//激活降级
@EnableCircuitBreaker
public class HystrixPayment8001Main {
    public static void main(String[] args) {
        SpringApplication.run(HystrixPayment8001Main.class, args);
    }
}
