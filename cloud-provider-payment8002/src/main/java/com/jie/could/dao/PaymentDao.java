package com.jie.could.dao;

import com.jie.could.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Description:
 *
 * @author LiJie
 * @date Created on 2020/6/1
 * WWW https://github.com/j6l
 */
@Mapper
public interface  PaymentDao {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}