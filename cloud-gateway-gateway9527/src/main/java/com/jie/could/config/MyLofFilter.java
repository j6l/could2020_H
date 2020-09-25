package com.jie.could.config;

import cn.hutool.core.date.DateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


/**
 * Description:
 *
 * @author LiJie
 * @date Created on 2020/6/3
 * WWW https://github.com/j6l
 */
@Component
@Slf4j
public class MyLofFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info( "*********** com in MyLogFiltewr   "+ DateTime.now() );
        String uname = exchange.getRequest().getQueryParams().getFirst( "uname" );
        if (uname == null) {
            log.info( "***********用户名为null 非法用户!!!!");
        }
        return chain.filter( exchange );
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
