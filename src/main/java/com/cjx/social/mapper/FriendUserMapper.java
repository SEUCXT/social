// Copyright 2018 Baidu Inc. All rights reserved.

package com.cjx.social.mapper;

import java.util.List;

import com.cjx.social.entity.Friend;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Chen Xiaotao (chenxiaotao@baidu.com).
 */
@Mapper
public interface FriendUserMapper{
    void addFriend(Friend friend);
    void deleteFriend(@Param("friendId") long friendId, @Param("myId") long myId);
        //void updateFriend(User user);
    List<Friend> getFriendByMyId(long id);
}