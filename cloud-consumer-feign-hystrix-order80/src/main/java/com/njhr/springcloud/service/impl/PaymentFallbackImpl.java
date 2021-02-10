package com.njhr.springcloud.service.impl;

import com.njhr.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 *
 * 为解决fallback方法与业务耦合，单写一个类处理
 * 此方法还是解决当前程序异常的降级
 * 如在controll写一个异常会调用该方法
 * 或者服务提供者宕机，此时controller调用service会出现异常，则还是会调用这边的方法
 * 总结，服务降级方法写在哪，就是解决那个服务的降级方法
 */
@Component
public class PaymentFallbackImpl implements PaymentService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "ok方法降级";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "timeout方法降级";
    }
}
