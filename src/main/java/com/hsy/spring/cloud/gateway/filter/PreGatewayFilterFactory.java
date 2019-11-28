package com.hsy.spring.cloud.gateway.filter;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

/**
 * 请求前置过滤器
 *
 * @author HuoShengyu
 * @version 1.0
 * @date 2019-11-28 14:40:01
 */
@Component
public class PreGatewayFilterFactory extends AbstractGatewayFilterFactory<PreGatewayFilterFactory.Config> {
	private static final Logger log = LoggerFactory.getLogger(PreGatewayFilterFactory.class);

	public static final String ENABLED_KEY = "enabled";

	public PreGatewayFilterFactory() {
		super(Config.class);
	}

	@Override
	public List<String> shortcutFieldOrder() {
		return Arrays.asList(ENABLED_KEY);
	}

	@Override
	public GatewayFilter apply(Config config) {
		return (exchange, chain) -> {
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
