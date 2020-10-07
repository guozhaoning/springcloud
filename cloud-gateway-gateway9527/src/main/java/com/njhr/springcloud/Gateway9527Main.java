package com.njhr.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient


/**
 *
 * 注意getaway网关不需要web服务，所以依赖总中的web以及author依赖删除，否则报错
 */
public class Gateway9527Main {
    public static void main(String[] args) {
        SpringApplication.run(Gateway9527Main.class, args);
    }
}
