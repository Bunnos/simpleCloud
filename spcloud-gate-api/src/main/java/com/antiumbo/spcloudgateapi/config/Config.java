package com.antiumbo.spcloudgateapi.config;

import com.antiumbo.spcloudgateapi.filter.error.DidiErrorAttributes;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Bran
 * @date 2018/4/30 0030.
 */
@Configuration
public class Config {

	@Bean
	public PatternServiceRouteMapper serviceRouteMapper() {
		return new PatternServiceRouteMapper(
				"(?<name>^.+)-(?<version>v.+$)",
				"${version}/${name}");
	}

	@Bean
	public DefaultErrorAttributes errorAttributes() {
		return new DidiErrorAttributes();
	}
}
