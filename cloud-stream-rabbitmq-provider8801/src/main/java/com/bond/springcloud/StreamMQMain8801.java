package com.bond.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author Stephen Zhang
 * @Date 2022/1/12 21:33
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamMQMain8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMQMain8801.class, args);
    }
}
