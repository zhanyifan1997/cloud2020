package cn.spectrumrpc.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import cn.spectrumrpc.springcloud.entities.CommonResult;
import cn.spectrumrpc.springcloud.entities.Payment;
import cn.spectrumrpc.springcloud.myHandler.CustomerBlockHandler;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 经济原则：宁花机器一分，不花程序员一秒。
 * -- Eric S. Raymond, UNIX哲学基础第十三条，《UNIX编程艺术》
 *
 * @author ifan
 * @version 1.0
 * @date 2020/03/07
 */
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource(){
        return new CommonResult(200, "按资源名称限流测试OK", new Payment(2020L, IdUtil.simpleUUID()));
    }

    public CommonResult handleException(BlockException blockException){
        return new CommonResult<>(444, blockException.getClass().getCanonicalName()+"\t服务不可用" );
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl(){
        return new CommonResult(200, "by url限流测试OK", new Payment(2020L, IdUtil.simpleUUID()));
    }
    //CustomerBlockHandler

    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
                    blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handlerException2")
    public CommonResult customerBlockHandler(){
        return new CommonResult(200, "客户自定义 限流测试OK", new Payment(2020L, IdUtil.simpleUUID()));
    }
}
