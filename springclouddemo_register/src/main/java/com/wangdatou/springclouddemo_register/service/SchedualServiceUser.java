package com.wangdatou.springclouddemo_register.service;

import com.wangdatou.springclouddemo_register.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "serivce-user",fallback = SchedualServiceUserHystric.class)
public interface SchedualServiceUser {

    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    String addUser(@RequestBody User user);

}
