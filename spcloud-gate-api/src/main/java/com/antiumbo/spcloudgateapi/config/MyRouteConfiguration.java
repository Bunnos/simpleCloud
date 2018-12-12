/*
package com.antiumbo.spcloudgateapi.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

*/
/**
 * @author antiumbo
 * @date on 2018/12/6
 **//*

@Configuration
public class MyRouteConfiguration {
    @Bean
    public RouteLocator myRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/access/**")
                        .filters(f -> f.stripPrefix(1).addRequestHeader("X-Forwarded-Prefix","/access"))
                        .uri("lb://PORTRAIT")
                        .id("access"))
                .build();
    }
}
*/
