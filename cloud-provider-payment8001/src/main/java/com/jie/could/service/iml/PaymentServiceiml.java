package com.jie.could.service.iml;

import com.jie.could.dao.PaymentDao;
import com.jie.could.entity.Payment;
import com.jie.could.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author LiJie
 * @date Created on 2020/6/1
 * WWW https://github.com/j6l
 */
@Service
public class PaymentServiceiml implements PaymentService {

    @Resource
    PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create( payment );
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById( id );
    }
}
