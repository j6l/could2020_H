package com.jie.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 *
 * @author LiJie
 * @date Created on 2020/6/2
 * WWW https://github.com/j6l
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
        // return new RandomRule();//随机
        return new RoundRobinRule();
    }
}
