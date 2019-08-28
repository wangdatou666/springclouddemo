package com.wangdatou.springclouddemo_ribbon.controller;

import com.netflix.discovery.converters.Auto;
import com.wangdatou.springclouddemo_ribbon.service.HelloService;
import com.wangdatou.springclouddemo_ribbon.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;
    @Autowired
    private MailService mailService;

    @GetMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return helloService.hiService( name );
    }

    @GetMapping("/sendMail")
    public String sendMail(){
        HashMap<String, String> mailMap = new HashMap<>();
        mailMap.put("mailTo","wangyuxin0620@163.com");
        mailMap.put("mailFrom","821319695@qq.com");
        mailMap.put("mailSubject","pring Boot Mail 邮件测试【文本】");
        mailMap.put("mailText","这里是一段通过rabbitmq发送的简单文本。");
        mailService.send(mailMap);
        return "邮件已发送";
    }

}
