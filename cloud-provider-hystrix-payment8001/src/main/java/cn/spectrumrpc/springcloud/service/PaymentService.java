package cn.spectrumrpc.springcloud.service;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * 经济原则：宁花机器一分，不花程序员一秒。
 * -- Eric S. Raymond, UNIX哲学基础第十三条，《UNIX编程艺术》
 *
 * @author ifan
 * @version 1.0
 * @date 2020/03/06
 */
public interface PaymentService {

    String paymentInfoOk(Integer id);

    String paymentInfoTimeOut(Integer id);

    String paymentCircuitBreaker(Integer id);
}
