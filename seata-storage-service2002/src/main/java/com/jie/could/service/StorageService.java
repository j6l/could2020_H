package com.jie.could.service;

/**
 * Description:
 *
 * @author LiJie
 * @date Created on 2020/6/15
 * WWW https://github.com/j6l
 */
public interface StorageService {


    // 扣减库存
    void decrease(Long productId, Integer count);
}
