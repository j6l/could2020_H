package com.jie.could;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Description:
 *
 * @author LiJie
 * @date Created on 2020/6/15
 * WWW https://github.com/j6l
 */
// @SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableTransactionManagement
public class SeataServiceMain2001 {
    public static void main(String[] args) {
        SpringApplication.run(SeataServiceMain2001.class, args);
    }
}
