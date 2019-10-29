package com.qyb.service;/*

亲元宝 2019/10/29  11:02
元宝

*/

import com.qyb.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findAllUser();

    User findUserById(Integer user_id);
    User findUserByUsername(String username);
}
