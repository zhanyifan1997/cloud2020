package cn.spectrumrpc.springcloud.controller;

import cn.spectrumrpc.springcloud.entities.CommonResult;
import cn.spectrumrpc.springcloud.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping("/account/decrease")
    public CommonResult decrease(Long userId , BigDecimal money){
        accountService.decrease(userId, money);

        return new CommonResult(200, "账户扣减余额成功");
    }
}
