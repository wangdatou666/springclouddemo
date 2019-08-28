package com.wangdatou.springclouddemo_mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController

public class SpringclouddemoMailApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringclouddemoMailApplication.class, args);
	}

	@Autowired
	private JavaMailSenderImpl mailSender;

	@RequestMapping("/sendMail")
	public String sendMail(){
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		// 设置收件人，寄件人
		simpleMailMessage.setTo(new String[] {"wangyuxin0620@163.com"});
		simpleMailMessage.setFrom("821319695@qq.com");
		simpleMailMessage.setSubject("Spring Boot Mail 邮件测试【文本】");
		simpleMailMessage.setText("这里是一段简单文本。");
		// 发送邮件
		mailSender.send(simpleMailMessage);
		return "邮件已发送";
	}

}
