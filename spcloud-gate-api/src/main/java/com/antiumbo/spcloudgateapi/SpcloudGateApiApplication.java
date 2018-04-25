package com.antiumbo.spcloudgateapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class SpcloudGateApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpcloudGateApiApplication.class, args);
	}
}
