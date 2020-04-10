package com.hsy.spring.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

/**
 * 启动类
 *
 * @author HuoShengyu
 * @version 1.0
 * @date 2019-11-28 14:40:01
 */
@EnableWebFlux
@SpringBootApplication
public class GatewayRun {
	public static void main(String[] args) {
		SpringApplication.run(GatewayRun.class, args);
	}
}
