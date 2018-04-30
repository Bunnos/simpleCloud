package com.antiumbo.spcloudgateapi;

import com.antiumbo.spcloudgateapi.filter.processor.DidiFilterProcessor;
import com.netflix.zuul.FilterProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author Administrator
 */
@EnableZuulProxy
@SpringBootApplication
public class SpcloudGateApiApplication {

	public static void main(String[] args) {
		FilterProcessor.setProcessor(new DidiFilterProcessor());
		SpringApplication.run(SpcloudGateApiApplication.class, args);
	}
}
