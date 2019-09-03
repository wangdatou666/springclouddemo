package com.wangdatou.springclouddemo_register.controller;

import com.wangdatou.springclouddemo_common.entity.User;
import com.wangdatou.springclouddemo_register.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PutMapping
    public String Register(@RequestBody User user){
        String code = registerService.getRundomCode(user.getUsername());
        return registerService.register(user,code);
    }

    @PostMapping("/getVerificationCode")
    public String getVerificationCode(@RequestBody Map<String,String> requestMap){
        String code = registerService.getRundomCode(requestMap.get("username"));
        requestMap.put("code",code);
        return registerService.getVerificationCode(requestMap);
    }

    @RequestMapping("/getCode")
    public String getCode(String username){
        return registerService.getRundomCode(username);
    }

}
