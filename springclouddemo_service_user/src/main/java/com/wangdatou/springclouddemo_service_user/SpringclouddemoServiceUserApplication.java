package com.wangdatou.springclouddemo_service_user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigurationProperties
@MapperScan("com.wangdatou.springclouddemo_service_user.dao")
public class SpringclouddemoServiceUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringclouddemoServiceUserApplication.class, args);
	}

}
