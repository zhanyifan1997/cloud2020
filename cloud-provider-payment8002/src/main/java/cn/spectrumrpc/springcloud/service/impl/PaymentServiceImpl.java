package cn.spectrumrpc.springcloud.service.impl;

import cn.spectrumrpc.springcloud.dao.PaymentDao;
import cn.spectrumrpc.springcloud.entities.Payment;
import cn.spectrumrpc.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 经济原则：宁花机器一分，不花程序员一秒。
 * -- Eric S. Raymond, UNIX哲学基础第十三条，《UNIX编程艺术》
 *
 * @author ifan
 * @version 1.0
 * @date 2020/03/05
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
