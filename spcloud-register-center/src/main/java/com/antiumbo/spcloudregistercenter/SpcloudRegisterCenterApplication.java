package com.antiumbo.spcloudregistercenter;

import com.google.common.collect.Lists;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 默柴柒柒
 */
@EnableEurekaServer
@SpringBootApplication
public class SpcloudRegisterCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpcloudRegisterCenterApplication.class, args);
    }
}
