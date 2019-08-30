package com.wangdatou.springclouddemo_register.controller;

import com.wangdatou.springclouddemo_register.entity.User;
import com.wangdatou.springclouddemo_register.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PutMapping
    public String Register(@RequestBody User user){
        return registerService.register(user);
    }

}
