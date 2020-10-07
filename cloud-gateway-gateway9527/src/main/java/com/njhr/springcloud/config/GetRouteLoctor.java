package com.njhr.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义配置route，不推荐
 *  path为访问地址，uri为映射到哪个地址
 */
@Configuration
public class GetRouteLoctor {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder builder = routeLocatorBuilder.routes();
        return builder.route("path_route_njhr1", predicateSpec -> predicateSpec.path("/guonei").uri("http://news.baidu.com/guonei")).build();

    }
}
