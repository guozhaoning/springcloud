package com.njhr.controller;


import com.njhr.entity.CommonResult;
import com.njhr.entity.Payment;
import com.njhr.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        log.info(payment.toString());
        int result = paymentService.create(payment);
        log.info("*****插入结果：" + result);

        if (result > 0) {  //成功
            return new CommonResult(200, "插入数据库成功", result);
        } else {
            return new CommonResult(444, "插入数据库失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentByID(id);
        log.info("*****查询结果：" + payment);
        if (payment != null) {  //说明有数据，能查询成功
            return new CommonResult(200, "查询成功", payment);
        } else {
            return new CommonResult(444, "没有对应记录，查询ID：" + id, null);
        }
    }
}

