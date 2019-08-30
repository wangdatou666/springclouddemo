package com.wangdatou.springclouddemo_register.service;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SchedualServiceMailHystric implements SchedualServiceMail {
    @Override
    public String sendRegisterMail(Map<String, String> mailMap) {
        return "网络异常";
    }
}
