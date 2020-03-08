package cn.spectrumrpc.springcloud.service.impl;

import cn.spectrumrpc.springcloud.dao.OrderDao;
import cn.spectrumrpc.springcloud.domain.Order;
import cn.spectrumrpc.springcloud.service.AccountService;
import cn.spectrumrpc.springcloud.service.OrderService;
import cn.spectrumrpc.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * 经济原则：宁花机器一分，不花程序员一秒。
 * -- Eric S. Raymond, UNIX哲学基础第十三条，《UNIX编程艺术》
 *
 * @author ifan
 * @version 1.0
 * @date 2020/03/08
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;;
    @Resource
    private AccountService accountService;
    @Override
    @GlobalTransactional(name = "fsp-create-order", rollbackFor = Exception.class)
    public void createOrder(Order order) {
        log.info("开始新建订单");
        // 新建订单
        orderDao.createOrder(order);
        log.info("订单微服务开始调用库存，做扣减");
        // 扣减库存
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("订单微服务开始调用库存，做扣减end");
        log.info("订单微服务开始调用账户，做扣减");
        // 扣减账户余额
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("订单微服务开始调用账户，做扣减end");
        //修改订单状态，从0->1 1代表已经完成
        log.info("修改订单状态start");
        orderDao.update(order.getUserId(), 0);
        log.info("修改订单状态end");
        log.info("下单结束!!!");
    }
}
