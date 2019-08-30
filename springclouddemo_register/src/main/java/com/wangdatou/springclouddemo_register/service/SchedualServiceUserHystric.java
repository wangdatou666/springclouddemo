package com.wangdatou.springclouddemo_register.service;

import com.wangdatou.springclouddemo_register.entity.User;
import org.springframework.stereotype.Component;

@Component
public class SchedualServiceUserHystric implements SchedualServiceUser {
    @Override
    public String addUser(User user) {
        return "网络异常";
    }
}
