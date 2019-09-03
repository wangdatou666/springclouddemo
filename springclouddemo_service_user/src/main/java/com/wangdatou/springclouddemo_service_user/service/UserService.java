package com.wangdatou.springclouddemo_service_user.service;

import com.wangdatou.springclouddemo_common.entity.User;
import com.wangdatou.springclouddemo_service_user.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@ResponseBody
@RequestMapping("/user")
public class UserService {

    @Autowired
    private UserDao userDao;

    @GetMapping
    public List<User> findAll(){
        return userDao.findAll();
    }

    @PutMapping
    public String addUser(@RequestBody User user){
        userDao.addUser(user);
        return "添加成功";
    }

}
