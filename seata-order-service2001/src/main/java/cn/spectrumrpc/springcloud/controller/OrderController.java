package cn.spectrumrpc.springcloud.controller;

import cn.spectrumrpc.springcloud.domain.Order;
import cn.spectrumrpc.springcloud.entities.CommonResult;
import cn.spectrumrpc.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 经济原则：宁花机器一分，不花程序员一秒。
 * -- Eric S. Raymond, UNIX哲学基础第十三条，《UNIX编程艺术》
 *
 * @author ifan
 * @version 1.0
 * @date 2020/03/08
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult createOrder(Order order){
        orderService.createOrder(order);
        return new CommonResult(200, "订单创建成功");
    }
}
