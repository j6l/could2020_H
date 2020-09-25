package com.jie.could;

import com.jie.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * Description:
 *
 * @author LiJie
 * @date Created on 2020/6/2
 * WWW https://github.com/j6l
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
public class order80 {

    public static void main(String[] args) {
        SpringApplication.run(order80.class, args);
    }
}
