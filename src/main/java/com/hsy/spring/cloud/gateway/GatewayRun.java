package com.hsy.spring.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@SpringBootApplication
public class GatewayRun {
	public static void main(String[] args) {
		SpringApplication.run(GatewayRun.class, args);
	}
}
