package com.wangdatou.springclouddemo_service_user.dao;


import com.wangdatou.springclouddemo_common.entity.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    void addUser(User user);
}
