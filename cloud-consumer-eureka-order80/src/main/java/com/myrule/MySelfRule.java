package com.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * 加入ribbon定义实现负载均衡得出方式
 * 默认加入loadbalance后为轮播均衡
 * 现在调整为随机
 *
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule() {
        //随机规则
        return new RandomRule();
    }
}
