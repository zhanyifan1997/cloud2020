package cn.spectrumrpc.springcloud.myHandler;

import cn.hutool.core.util.IdUtil;
import cn.spectrumrpc.springcloud.entities.CommonResult;
import cn.spectrumrpc.springcloud.entities.Payment;
import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * 经济原则：宁花机器一分，不花程序员一秒。
 * -- Eric S. Raymond, UNIX哲学基础第十三条，《UNIX编程艺术》
 *
 * @author ifan
 * @version 1.0
 * @date 2020/03/07
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(444, "客户自定义，global handlerException---1");
    }

    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(444, "客户自定义，global handlerException---2");
    }
}
