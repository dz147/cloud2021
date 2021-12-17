package com.bond.springcloud.controller;

import com.bond.springcloud.entities.Payment;
import com.bond.springcloud.model.ApiResult;
import com.bond.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Stephen
 * @date: 2021-12-17 13:09
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController extends CommonResult {
    @Resource
    private PaymentService paymentService;

    @Resource
    private EurekaDiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String port;

    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入数据的ID:\t" + payment.getId());
        log.info("插入结果：" + result);
        if (result > 0) {
            return success("port:" + port, true);
        } else {
            return failed("新增数据失败");
        }
    }

    @GetMapping("/get/{id}")
    public ApiResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("** *查询结果：" + payment);
        if (payment != null) {
            return success("port:" + port, payment);
        } else {
            return failed("暂无此数据");
        }
    }

    @GetMapping("/discovery")
    public void discovery() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("element:\t" + element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
    }

    @GetMapping("/lb")
    public String getPaymentLB() {
        return port;
    }


    @GetMapping(value = "/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            // 暂停3秒钟
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return port;
    }

    @GetMapping("/zipkin")
    public String paymentZipkin() {
        return "hellp zipkin";
    }
}
