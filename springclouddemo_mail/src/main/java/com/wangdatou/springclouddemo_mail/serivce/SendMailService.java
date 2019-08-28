package com.wangdatou.springclouddemo_mail.serivce;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "q_mail")
public class SendMailService {

    @Autowired
    private JavaMailSenderImpl mailSender;

    @RabbitHandler
    public void process(Map<String,String> mailMap) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        // 设置收件人，寄件人
        simpleMailMessage.setTo(new String[] {mailMap.get("mailTo")});
        simpleMailMessage.setFrom(mailMap.get("mailFrom"));
        simpleMailMessage.setSubject(mailMap.get("mailSubject"));
        simpleMailMessage.setText(mailMap.get("mailText"));
        // 发送邮件
        mailSender.send(simpleMailMessage);
    }

}
