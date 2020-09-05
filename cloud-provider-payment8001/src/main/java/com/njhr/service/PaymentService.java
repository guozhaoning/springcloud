package com.njhr.service;

import com.njhr.entity.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentByID(@Param("id") Long id);
}
