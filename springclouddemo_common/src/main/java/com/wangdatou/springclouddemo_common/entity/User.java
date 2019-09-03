package com.wangdatou.springclouddemo_common.entity;

import lombok.Data;

@Data
public class User {

    private String username;
    private String password;
    private String telephone;
    private String email;
    private String verificationCode;

}
