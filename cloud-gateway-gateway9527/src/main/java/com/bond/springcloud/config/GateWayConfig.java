package com.bond.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Stephen Zhang
 * @Date 2021/12/25 18:31
 * @Version 1.0
 */
@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("id",
                r -> r.path("/guonei").uri("http://news.baidu.com/guonei"));
        routes.route("id2",
                r -> r.path("/guoji").uri("http://news.baidu.com/guoji"));
        return routes.build();
    }
}
