package com.hsy.spring.cloud.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import java.util.Collections;
import java.util.List;

/**
 * 请求前置过滤器
 *
 * @author HuoShengyu
 * @version 1.0
 * @date 2019-11-28 14:40:01
 */
@Slf4j
@Order(3)
@Component
public class SecondGatewayFilterFactory extends AbstractGatewayFilterFactory<SecondGatewayFilterFactory.Config> {
    public static final String ENABLED_KEY = "enabled";

    public SecondGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList(ENABLED_KEY);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            log.info("执行过滤器[{}]", this.getClass().getName());
            MultiValueMap<String, String> queryParams = exchange.getRequest().getQueryParams();
            queryParams.forEach((key, value) -> {
                log.info("~~~~~~{} -> {}", key, value);
            });
            return chain.filter(exchange);
        };
    }

    public static class Config {
        private boolean enabled;

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }
    }
}
