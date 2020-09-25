package com.jie.could.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author LiJie
 * @date Created on 2020/6/7
 * WWW https://github.com/j6l
 */
@RestController
@Slf4j
public class NacosMain83 {

    @Resource
    private RestTemplate restTemplate;

    //配置在yml文件里面更好的实现生产配置
    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @GetMapping(value = "/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Long id)
    {
        return restTemplate.getForObject(serverURL+"/payment/nacos/"+id,String.class);
    }

}
