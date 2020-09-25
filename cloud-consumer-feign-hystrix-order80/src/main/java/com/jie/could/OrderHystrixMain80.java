package com.jie.could;

/**
 * Description:
 *
 * @author LiJie
 * @date Created on 2020/6/3
 * WWW https://github.com/j6l
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderHystrixMain80 {

    public static void main(String[] args) {
        SpringApplication.run( OrderHystrixMain80.class, args);
    }
}
