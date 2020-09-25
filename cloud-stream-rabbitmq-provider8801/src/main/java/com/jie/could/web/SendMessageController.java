package com.jie.could.web;

import com.jie.could.service.IMessageProvideriml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author LiJie
 * @date Created on 2020/6/7
 * WWW https://github.com/j6l
 */
@RestController
public class SendMessageController {

    @Autowired
    IMessageProvideriml messageProvider;

    @GetMapping(value = "/sendMessage")
    public String sendMessage()
    {
        return messageProvider.send();
    }

}
