package com.wangdatou.springclouddemo_register.service;

import com.wangdatou.springclouddemo_common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class RegisterService {

    @Autowired
    private SchedualServiceUser schedualServiceUser;
    @Autowired
    private SchedualServiceMail schedualServiceMail;
    @Autowired
    private SchedualServiceMessage schedualServiceMessage;

    public String register(User user,String code){
        String resultStr;
        if (!user.getVerificationCode().equals(code)){
            resultStr = "验证码错误";
            return resultStr;
        }
        resultStr = schedualServiceUser.addUser(user);
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

    public String getVerificationCode(Map<String, String> requestMap) {
        String code = requestMap.get("code");
        requestMap.put("templateParam","{\"code\":\""+code+"\"}");
        schedualServiceMessage.sendMessage(requestMap);
        return "验证码已发送";
    }

    @Cacheable("code")
    public String getRundomCode(String username) {
        String verifyCode = String
                .valueOf(new Random().nextInt(899999) + 100000);
        return verifyCode;
    }
}
