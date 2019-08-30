package com.wangdatou.springclouddemo_register.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(value = "SERVICE-MAIL",fallback = SchedualServiceMailHystric.class)
public interface SchedualServiceMail {

    @RequestMapping(value = "/sendRegisterMail",method = RequestMethod.POST)
    String sendRegisterMail(@RequestBody Map<String,String> mailMap);

}
