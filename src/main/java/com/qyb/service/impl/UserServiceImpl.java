package com.qyb.service.impl;/*

亲元宝 2019/10/29  11:03
元宝

*/

import com.qyb.dao.UserMapper;
import com.qyb.pojo.User;
import com.qyb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;



    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

    @Override
    public User findUserById(Integer user_id) {
        return userMapper.findUserById(user_id);
    }

    @Override
    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }
}
