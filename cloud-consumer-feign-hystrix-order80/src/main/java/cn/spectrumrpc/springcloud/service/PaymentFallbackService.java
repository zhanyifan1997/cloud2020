package cn.spectrumrpc.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * 经济原则：宁花机器一分，不花程序员一秒。
 * -- Eric S. Raymond, UNIX哲学基础第十三条，《UNIX编程艺术》
 *
 * @author ifan
 * @version 1.0
 * @date 2020/03/06
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfoOk(Integer id) {
        return "PaymentFallbackService fallback paymentInfoOk";
    }

    @Override
    public String paymentInfoTimeOut(Integer id) {
        return "PaymentFallbackService fallback paymentInfoTimeOut";
    }
}
