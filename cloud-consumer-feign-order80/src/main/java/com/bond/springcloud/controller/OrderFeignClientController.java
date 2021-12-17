package com.bond.springcloud.controller;

import com.bond.springcloud.entities.Payment;
import com.bond.springcloud.model.ApiResult;
import com.bond.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: stephen
 **/
@RestController
@RequestMapping("/consumer")
public class OrderFeignClientController extends CommonResult {

    @Resource
    private PaymentFeignService paymentFeignService;

    /**
     * 根据id查询
     */
    @GetMapping(value = "/payment/get/{id}")
    public ApiResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    /**
     * 模拟feign超时
     */
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout() {
        // openfeign-ribbon, 客户端一般默认等待1秒钟
        return paymentFeignService.paymentFeignTimeout();
    }


}
