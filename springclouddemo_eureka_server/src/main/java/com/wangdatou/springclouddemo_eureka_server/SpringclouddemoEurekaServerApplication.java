package com.wangdatou.springclouddemo_eureka_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringclouddemoEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringclouddemoEurekaServerApplication.class, args);
	}

}
