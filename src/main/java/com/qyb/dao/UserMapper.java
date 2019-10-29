package com.qyb.dao;/*

亲元宝 2019/10/29  10:58
元宝

*/

import com.qyb.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> findAllUser();
    User findUserById(Integer user_id);

    User findUserByUsername(String username);
}
