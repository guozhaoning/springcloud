package com.njhr.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
public class Provider8801Main {
    public static void main(String[] args) {
        SpringApplication.run(Provider8801Main.class, args);
    }
}
