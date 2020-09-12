package com.njhr.springcloud.service;

import cn.hutool.core.util.IdUtil;
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
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "150000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        //降级允许等待3秒钟
        //定义异常，是服务报错，运行服务降级
//        int a = 10/0;
        //超时运行降级
        int timeNum = 1;
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

    /**
     *
     *
     * 服务熔断的配置
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   //熔断触发的最最小个数，默认10s内20个，此为10s内10个
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //时间范围，就是多久后尝试恢复链路
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少后跳闸
            /**
             * 解释：在请求次数为10次的范围内，如果错误次数达到6次，则断路器开启，断路器开启之后，即使访问正确，依然调用fallback方法
             * 在断路器开启的10秒后，默认为5秒，这里设置了10秒，进入一个半开状态，尝试恢复链路
             * 此时，有且仅有一个请求进入，并且请求成功，则断路器关闭，并重新计次10次，错误6次，断路器打开
             * 如果请求失败，则断路器开启，切断链路，等待10s进入半开，循环往复
             *
             *
             *
             *
             */
    })
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("*****id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + " 调用成功，流水号:" + serialNumber;

    }

    public String paymentCircuitBreaker_fallback(Integer id) {
        return " id 不能为负数，请稍后再试";
    }
}
