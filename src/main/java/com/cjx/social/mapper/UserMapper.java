// Copyright 2018 Baidu Inc. All rights reserved.

package com.cjx.social.mapper;

import com.cjx.social.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Chen Xiaotao (chenxiaotao@baidu.com).
 */
@Mapper
public interface UserMapper {
    void addUser(User user);
    void deleteUser(String username);
    void updateUser(User user);
    User getUserByUsername(String username);
    User getFriendListByMyId(long id);
}

