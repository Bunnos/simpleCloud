package com.antiumbo.spcloudportrait.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Bran
 * @date 2018/4/25 0025.
 */
@Configuration
public class FullLogConfiguration {
	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.BASIC;
	}
}
