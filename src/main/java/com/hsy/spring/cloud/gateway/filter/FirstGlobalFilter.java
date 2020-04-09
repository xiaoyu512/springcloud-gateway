package com.hsy.spring.cloud.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 全局过滤器
 *
 * @author HuoShengyu
 * @version 1.0
 * @date 2019-11-28 14:40:01
 */
@Slf4j
@Order(2)
@Component
public class FirstGlobalFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("执行全局过滤器[{}]", this.getClass().getName());
        return chain.filter(exchange);
    }
}
