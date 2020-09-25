package com.jie.could.service;

import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author LiJie
 * @date Created on 2020/6/3
 * WWW https://github.com/j6l
 */
@Component
public class PaymentServiceiml implements PaymentService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK , (┬＿┬)";

    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut , (┬＿┬)";
    }

}
