// Copyright 2018 Baidu Inc. All rights reserved.

package com.cjx.social.service;

import com.cjx.social.entity.User;


/**
 * @author Chen Xiaotao (chenxiaotao@baidu.com).
 */
public interface UserService{
    void addUser(User user);
    void deleteUser(String username);
    User getUserByUsername(String username);
    void updateUser(User user);
    User getFriendListByMyId(long id);
}
