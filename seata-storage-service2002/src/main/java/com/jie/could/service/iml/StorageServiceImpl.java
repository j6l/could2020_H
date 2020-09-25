package com.jie.could.service.iml;

import com.jie.could.dao.StorageDao;
import com.jie.could.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author LiJie
 * @date Created on 2020/6/15
 * WWW https://github.com/j6l
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageDao storageDao;

    // 扣减库存
    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存开始");
        int i =10/0;
        storageDao.decrease(productId,count);
        log.info("------->storage-service中扣减库存结束");
    }

}
