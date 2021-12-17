package com.bond.springcloud.service;

import com.bond.springcloud.entities.Payment;
import com.bond.springcloud.model.ApiResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: stephen
 **/
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    /**
     * 根据id查询
     */
    @GetMapping(value = "/payment/get/{id}")
    ApiResult<Payment> getPaymentById(@PathVariable("id") Long id);

    /**
     * 模拟feign超时
     */
    @GetMapping(value = "/payment/feign/timeout")
    String paymentFeignTimeout();
}
