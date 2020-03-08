package cn.spectrumrpc.springcloud.service.impl;

import cn.spectrumrpc.springcloud.dao.StorageDao;
import cn.spectrumrpc.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("storage-service 扣减库存start");
        storageDao.decrease(productId, count);
        log.info("storage-service 扣减库存end");
    }
}
