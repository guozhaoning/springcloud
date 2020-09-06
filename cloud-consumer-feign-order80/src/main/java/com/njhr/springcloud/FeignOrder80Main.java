package com.njhr.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

/**
 *
 * openFeign用于客户端，类似于上述order，将使用不同方式实现服务之间的调用
 */
@SpringBootApplication
@EnableFeignClients
public class FeignOrder80Main {
    public static void main(String[] args) {
        SpringApplication.run(FeignOrder80Main.class, args);
    }
}
