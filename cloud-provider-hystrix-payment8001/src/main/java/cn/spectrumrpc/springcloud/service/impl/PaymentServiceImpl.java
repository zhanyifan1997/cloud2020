package cn.spectrumrpc.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.spectrumrpc.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * 经济原则：宁花机器一分，不花程序员一秒。
 * -- Eric S. Raymond, UNIX哲学基础第十三条，《UNIX编程艺术》
 *
 * @author ifan
 * @version 1.0
 * @date 2020/03/06
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    /**
     * 正常访问
     * @param id
     * @return
     */
    @Override
    public String paymentInfoOk(Integer id){
        return "线程池:" + Thread.currentThread().getName() + "  paymentInfoOk, id:" + id;
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfoTimeOut(Integer id){
//        int age = 10 /0;
        int timeNumber = 3000;
        try {
            TimeUnit.MILLISECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread().getName() + "  paymentInfoTimeOut, id:" + id;
    }

    public String paymentInfoTimeOutHandler(Integer id){
        return "线程池:" + Thread.currentThread().getName() + "8001  系统运行报错或繁忙 fallback, id:" + id;
    }

    // ------ 服务熔断

    /**
     * 详细配置参考 com.netflix.hystrix.HystrixCommandProperties
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //请求次数,熔断器将从关闭状态变为打开
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期/时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") // 失败率达到多少后跳匝
    })
    @Override
    public String paymentCircuitBreaker(Integer id){

        if(id < 0){
            throw new RuntimeException("id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功,流水号:" + serialNumber;
    }

    public String paymentCircuitBreakerFallback(Integer id){
        return "id 不能为负数, id=" + id;
    }
}
