package com.wangdatou.springclouddemo_ribbon.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Service
public class MailService {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(Map<String,String> mailMap) {
        this.rabbitTemplate.convertAndSend("q_mail", mailMap);
    }

}
