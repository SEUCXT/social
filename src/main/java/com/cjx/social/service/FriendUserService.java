// Copyright 2018 Baidu Inc. All rights reserved.

package com.cjx.social.service;

import java.util.List;

import com.cjx.social.entity.Friend;
import org.apache.ibatis.annotations.Param;

/**
 * @author Chen Xiaotao (chenxiaotao@baidu.com).
 */
public interface FriendUserService {
    void addFriend(Friend firend);
    void deleteFriend(@Param("friendId") long friendId, @Param("myId") long myId);
    List<Friend> getFriendByMyId(long id);
}