package cn.spectrumrpc.springcloud.service;

import java.math.BigDecimal;

/**
 * 经济原则：宁花机器一分，不花程序员一秒。
 * -- Eric S. Raymond, UNIX哲学基础第十三条，《UNIX编程艺术》
 *
 * @author ifan
 * @version 1.0
 * @date 2020/03/08
 */

public interface AccountService {
    void decrease(Long userId, BigDecimal money);
}
