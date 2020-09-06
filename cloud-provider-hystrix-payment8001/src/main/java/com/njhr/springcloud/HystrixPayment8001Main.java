package com.njhr.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HystrixPayment8001Main {
    public static void main(String[] args) {
        SpringApplication.run(HystrixPayment8001Main.class, args);
    }
}
