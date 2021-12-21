package com.bond.springcloud.controller;

import com.bond.springcloud.entities.Payment;
import com.bond.springcloud.lb.LoadBalancer;
import com.bond.springcloud.model.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author stephen
 **/
@RestController
@Slf4j
public class OrderController extends CommonResult {

    //private final static String PAYMENT_URL = "http://localhost:8001";
    private final static String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/get/{id}")
    public ApiResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, ApiResult.class, id);
    }

    @GetMapping("/consumer/payment/create")
    public ApiResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, ApiResult.class);
    }

    @GetMapping("/consumer/payment/getEntity/{id}")
    public ApiResult<Payment> getPaymentById2(@PathVariable("id") Long id) {
        ResponseEntity<ApiResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, ApiResult.class, id);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return failed("失败");
        }
    }

    @GetMapping("/consumer/payment/createEntity")
    public ApiResult<Payment> create2(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, ApiResult.class);
    }

    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0) {
            return null;
        }

        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();

        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }

    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/zipkin", String.class);
    }


}
