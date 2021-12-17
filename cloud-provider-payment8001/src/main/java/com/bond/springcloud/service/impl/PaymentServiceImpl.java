package com.bond.springcloud.service.impl;

import com.bond.springcloud.dao.PaymentDao;
import com.bond.springcloud.entities.Payment;
import com.bond.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: Stephen
 * @date: 2021-12-17 13:09
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
