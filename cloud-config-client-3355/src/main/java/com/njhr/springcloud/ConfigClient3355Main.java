package com.njhr.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
//动态刷新的注解
//设置动态刷新完成后，需要手动发送post请求，才能够刷新

@SpringBootApplication
@RefreshScope
public class ConfigClient3355Main {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient3355Main.class, args);
    }
}
