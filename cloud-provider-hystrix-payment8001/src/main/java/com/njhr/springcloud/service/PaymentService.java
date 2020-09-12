package com.njhr.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    public String paymentInfo_OK(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + " paymentInfo_OK,id:" + id + "\t" + "哈哈哈";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        //降级允许等待3秒钟
        //定义异常，是服务报错，运行服务降级
        int a = 10/0;
        //超时运行降级
        int timeNum = 5;
        try {
            TimeUnit.SECONDS.sleep(timeNum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread().getName() + " paymentInfo_TimeOut,id:" + id + "\t" + "呜呜呜" + "耗时(秒)" + timeNum;
    }

    /**
     *
     * 服务提供者出错或服务宕机使用服务降级调用的方法
     * @param id
     * @return
     */
    public String paymentInfo_TimeOutHandler(Integer id) {
        return "/(ToT)/调用支付接口超时或异常: \t" + "\t当前线程池名字:" + Thread.currentThread().getName();
    }
}
