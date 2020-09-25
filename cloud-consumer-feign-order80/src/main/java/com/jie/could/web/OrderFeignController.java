package com.jie.could.web;

import com.jie.could.entity.CommonResult;
import com.jie.could.entity.Payment;
import com.jie.could.service.PaymentFrign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author LiJie
 * @date Created on 2020/6/2
 * WWW https://github.com/j6l
 */
@Slf4j
@RestController
public class OrderFeignController {

    @Resource
    private PaymentFrign paymentFrign;

    @GetMapping("/consumer/payment/create")
    public int create(Payment payment){
        return paymentFrign.create( payment );
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){

        return paymentFrign.getPaymentById( id );
    }
}
