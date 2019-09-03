package com.wangdatou.springclouddemo_register.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient(value = "SERVICE-MESSAGE",fallback = SchedualServiceMessageHystric.class)
public interface SchedualServiceMessage {

    @RequestMapping(value = "/sendMessage",method = RequestMethod.POST)
    String sendMessage(@RequestBody Map<String,String> messageMap);

}
