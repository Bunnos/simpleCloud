package com.antiumbo.spcloudconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author Bran
 */
@EnableConfigServer
@SpringBootApplication
public class SpcloudConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpcloudConfigApplication.class, args);
	}
}
