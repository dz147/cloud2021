package com.bond.springcloud.service;

import com.bond.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: Stephen
 * @date: 2021-12-17 13:09
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
