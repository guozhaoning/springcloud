package com.njhr.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.njhr.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
//没有特别说明就是用统一的降级方法
//还需要说明，指定的方法需要与接口方法的参数列表一致，否则报错
//@DefaultProperties(defaultFallback = "fallBack")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_OK(id);
        log.info(result);
        return result;
    }

    /**
     *
     *
     * 加入降级机制
     * 这里的是自己的降级保护
     * 如果自己的服务请求在3秒钟以内不运行fallback方法
     * 去调用服务接口
     * 而服务接口也有降级保护
     * 所以当前会返回服务服务提供者的降级保护返回值
     * @param id
     * @return
     */
//  指定方法
//    @HystrixCommand(fallbackMethod = "fallBack")
    //没有指定方法使用统一方法
//    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_TimeOut(id);
        log.info("**************" + result);
        return result;
    }

    public String fallBack(@PathVariable("id") Integer id) {

        return "兜底方法";
    }


}
