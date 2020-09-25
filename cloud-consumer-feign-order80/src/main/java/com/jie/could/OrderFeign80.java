package com.jie.could;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Description:
 *
 * @author LiJie
 * @date Created on 2020/6/2
 * WWW https://github.com/j6l
 */
@SpringBootApplication
@EnableFeignClients
public class OrderFeign80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeign80.class, args);
    }
}
