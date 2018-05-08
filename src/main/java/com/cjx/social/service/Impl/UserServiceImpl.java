// Copyright 2018 Baidu Inc. All rights reserved.

package com.cjx.social.service.Impl;

import com.cjx.social.entity.User;
import com.cjx.social.mapper.UserMapper;
import com.cjx.social.service.UserService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Chen Xiaotao (chenxiaotao@baidu.com).
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void deleteUser(String username){
        userMapper.deleteUser(username);
    }

    @Override
    public User getUserByUsername(String username){
        User user = userMapper.getUserByUsername(username);
        return user;
    }

    @Override
    public void updateUser(User user){
        userMapper.updateUser(user);
    }

    @Override
    public User getFriendListByMyId(long id) {
        User user = userMapper.getFriendListByMyId(id);
        return user;
    }

}
