package com.wangdatou.springclouddemo_register.service;

import com.wangdatou.springclouddemo_register.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Service
public class RegisterService {

    @Autowired
    private SchedualServiceUser schedualServiceUser;
    @Autowired
    private SchedualServiceMail schedualServiceMail;

    public String register(User user){
        String resultStr = schedualServiceUser.addUser(user);
        if ("添加成功".equals(resultStr)){
            HashMap<String, String> mailMap = new HashMap<>();
            mailMap.put("mailTo", user.getEmail());
            mailMap.put("username", user.getUsername());
            resultStr = schedualServiceMail.sendRegisterMail(mailMap);
            if ("邮件已发送".equals(resultStr)){
                resultStr = "注册成功";
                return resultStr;
            }
            return resultStr;
        }
        resultStr = "注册失败";
        return resultStr;
    }

}
