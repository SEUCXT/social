// Copyright 2018 Baidu Inc. All rights reserved.

package com.cjx.social.controller;

import java.util.List;

import com.cjx.social.entity.Friend;
import com.cjx.social.service.FriendUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chen Xiaotao (chenxiaotao@baidu.com).
 */
@Controller
@RequestMapping("/friend")
public class FriendController {
    @Autowired
    FriendUserService friendUserService;

    @RequestMapping("/add")
    @ResponseBody
    public void add(@RequestParam("myId") long myId,
                    @RequestParam("friendId") long friendId,
                    @RequestParam("relationship") String relationship) {
        Friend friend = new Friend();
        friend.setMyId(myId);
        friend.setFriendId(friendId);
        friend.setRelationship(relationship);
        friendUserService.addFriend(friend);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public void delete(@RequestParam("friendId") long friendId,
                       @RequestParam("myId") long myId) {
        friendUserService.deleteFriend(friendId, myId);
    }

    @RequestMapping("/getFriends")
    @ResponseBody
    public List<Friend> getFriends(@RequestParam("id") long id) {
        return friendUserService.getFriendByMyId(id);
    }

    @RequestMapping("/updateFriends")
    @ResponseBody
    public void update(@RequestParam("myId") long myId,
                       @RequestParam("friendId") long friendId,
                       @RequestParam("relationship") String relationship) {
        friendUserService.updateFriend(myId,friendId,relationship);
    }
}
