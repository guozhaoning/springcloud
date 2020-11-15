package com.njhr.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author GuoZhaoning
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosOrder83Main {
    public static void main(String[] args) {
        SpringApplication.run(NacosOrder83Main.class, args);
    }
}
