package com.jie.could;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Description:
 *
 * @author LiJie
 * @date Created on 2020/6/1
 * WWW https://github.com/j6l
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class payment8001 {

    public static void main(String[] args) {
        SpringApplication.run(payment8001.class, args);
    }
}
