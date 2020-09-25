package com.jie.could.service;

import cn.hutool.core.util.IdUtil;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author LiJie
 * @date Created on 2020/6/7
 * WWW https://github.com/j6l
 */

@EnableBinding(Source.class) //定义消息的推送管道
public class IMessageProvideriml implements IMessageProvider{

    @Resource
    private MessageChannel output; // 消息发送管道

    @Override
    public String send() {
        String serial = IdUtil.objectId();
        output.send( MessageBuilder.withPayload(serial).build());
        System.out.println("*****serial: "+serial);
        return null;
    }

}
