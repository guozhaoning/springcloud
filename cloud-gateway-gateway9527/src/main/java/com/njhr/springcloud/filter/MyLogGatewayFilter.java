package com.njhr.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

@Component
@Slf4j
public class MyLogGatewayFilter implements GlobalFilter, Ordered {
    /**
     * 过滤器的具体业务
     *
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //serverWebExchange相当于原来httpservlet
        log.info("******come in MyLogGatewayFilter" + new Date());
        Object object;
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if (StringUtils.isEmpty(uname)) {
            log.info("****用户名为null 非法用户 ");
            //响应状态码
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            //意思是设置完成
            return exchange.getResponse().setComplete();
        }
        //满足则执行下一个过滤器
        return chain.filter(exchange);
    }

    /**
     * 主要是过滤器的执行次序，数值越小，越靠前
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
