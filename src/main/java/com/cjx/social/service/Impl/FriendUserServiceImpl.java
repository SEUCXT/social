// Copyright 2018 Baidu Inc. All rights reserved.

package com.cjx.social.service.Impl;

import java.util.List;

import com.cjx.social.entity.Friend;
import com.cjx.social.mapper.FriendUserMapper;
import com.cjx.social.service.FriendUserService;
import com.sun.org.glassfish.gmbal.ManagedObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Chen Xiaotao (chenxiaotao@baidu.com).
 */

@Service
public class FriendUserServiceImpl implements FriendUserService{
    @Autowired
    FriendUserMapper friendMap;

    @Override
    public void addFriend(Friend friend){
        friendMap.addFriend(friend);
    }

    @Override
    public void deleteFriend(long friendId,long myId){
        friendMap.deleteFriend(friendId,myId);
    }

    @Override
    public List<Friend> getFriendByMyId(long id) {
        return friendMap.getFriendByMyId(id);
    }

    @Override
    public void updateFriend(long myId,long friendId, String relationship){
        friendMap.updateFriend(myId,friendId,relationship);}
}
