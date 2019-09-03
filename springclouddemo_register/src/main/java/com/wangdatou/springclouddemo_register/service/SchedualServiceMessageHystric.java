package com.wangdatou.springclouddemo_register.service;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SchedualServiceMessageHystric implements SchedualServiceMessage {
    @Override
    public String sendMessage(Map<String, String> messageMap) {
        return "网络异常";
    }
}
