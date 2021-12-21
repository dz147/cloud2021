package com.bond.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: Stephen
 * @date: 2021-12-21 15:48
 */
@Configuration
public class ApplicationContextConfig {

    /**
     * @LoadBalanced//开启负载均衡
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}