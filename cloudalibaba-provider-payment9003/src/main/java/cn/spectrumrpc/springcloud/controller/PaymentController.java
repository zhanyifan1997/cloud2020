package cn.spectrumrpc.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import cn.spectrumrpc.springcloud.entities.CommonResult;
import cn.spectrumrpc.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 经济原则：宁花机器一分，不花程序员一秒。
 * -- Eric S. Raymond, UNIX哲学基础第十三条，《UNIX编程艺术》
 *
 * @author ifan
 * @version 1.0
 * @date 2020/03/07
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static Map<Long , Payment> hashMap = new HashMap<>();
    static {
        hashMap.put(1L,new Payment(1L, IdUtil.simpleUUID()));
        hashMap.put(2L,new Payment(2L, IdUtil.simpleUUID()));
        hashMap.put(3L,new Payment(3L, IdUtil.simpleUUID()));
    }

    @GetMapping("/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        Payment payment = hashMap.get(id);
        return new CommonResult<>(200, "from mysql,serverPort:" + serverPort, payment);
    }
}
