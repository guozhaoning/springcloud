package com.njhr.springcloud.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public String paymentInfo_OK(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + " paymentInfo_OK,id:" + id + "\t" + "哈哈哈";
    }
}
