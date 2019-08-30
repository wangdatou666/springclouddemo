package com.wangdatou.springclouddemo_register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class SpringclouddemoRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringclouddemoRegisterApplication.class, args);
	}

}
