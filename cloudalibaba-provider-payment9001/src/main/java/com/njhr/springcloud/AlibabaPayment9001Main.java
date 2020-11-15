package com.njhr.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaPayment9001Main {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaPayment9001Main.class, args);
    }
}
