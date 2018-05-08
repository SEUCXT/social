// Copyright 2018 Baidu Inc. All rights reserved.

package com.cjx.social.entity;

/**
 * @author Chen Xiaotao (chenxiaotao@baidu.com).
 */
public class Friend {
    private long myId;
    private long friendId;
    private String relationship;

    public long getMyId() {
        return myId;
    }

    public void setMyId(long myId) {
        this.myId = myId;
    }

    public long getFriendId() {
        return friendId;
    }

    public void setFriendId(long friendId) {
        this.friendId = friendId;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }
}
