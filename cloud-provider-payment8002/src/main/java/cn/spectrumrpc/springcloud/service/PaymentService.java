package cn.spectrumrpc.springcloud.service;

import cn.spectrumrpc.springcloud.entities.Payment;

/**
 * 经济原则：宁花机器一分，不花程序员一秒。
 * -- Eric S. Raymond, UNIX哲学基础第十三条，《UNIX编程艺术》
 *
 * @author ifan
 * @version 1.0
 * @date 2020/03/05
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
