package com.jie.could;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Description:
 *
 * @author LiJie
 * @date Created on 2020/6/2
 * WWW https://github.com/j6l
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsul80 {

    // D:\RSS\consul_1.7.3
    // consul agent -dev

    public static void main(String[] args) {
        SpringApplication.run( OrderConsul80.class, args);
    }
}
