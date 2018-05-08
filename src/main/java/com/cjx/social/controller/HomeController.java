// Copyright 2018 Baidu Inc. All rights reserved.

package com.cjx.social.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.cjx.social.entity.User;
import com.cjx.social.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Chen Xiaotao (chenxiaotao@baidu.com).
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    UserService userService;

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "HelloWorld";
    }

    @RequestMapping("/add")
    @ResponseBody
    public void add(@RequestParam("username") String username,
                    @RequestParam("password") String password,
                    @RequestParam("age") int age,
                    @RequestParam("location") String  location,
                    @RequestParam("signature") String signature,
                    @RequestParam("gender") String gender,
                    @RequestParam("birthday") String birthday,
                    @RequestParam("phonenumber") String phonenumber,
                    @RequestParam("email") String email) throws Exception{
        User user1=new User();
        user1.setUsername(username);
        user1.setPassword(password);
        user1.setAge(age);
        user1.setLocation(location);
        user1.setSignature(signature);
        user1.setGender(gender);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
        java.util.Date date=sdf.parse(birthday);
        user1.setBirthday(date);
        user1.setPhonenumber(phonenumber);
        user1.setEmail(email);

        userService.addUser(user1);
    }
    @RequestMapping("/delete")
    @ResponseBody
    public void delete(@RequestParam("username") String username){
        userService.deleteUser(username);
    }
    @RequestMapping("/select")
    @ResponseBody
    public User select(@RequestParam("username") String username){
        User user2=userService.getUserByUsername(username);
        return user2;
    }
    @RequestMapping("/update")
    @ResponseBody
    public void update(@RequestParam("id") long id,
                       @RequestParam("age") int age,
                       @RequestParam("gender") String gender,
                       @RequestParam("location") String location,
                       @RequestParam("signature") String signature,
                       @RequestParam("birthday") String birthday)throws Exception{
        User user3=new User();
        user3.setId(id);
        user3.setAge(age);
        user3.setGender(gender);
        user3.setLocation(location);
        user3.setSignature(signature);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
        java.util.Date date=sdf.parse(birthday);
        user3.setBirthday(date);
        userService.updateUser(user3);
    }

    @RequestMapping("/getFriends")
    @ResponseBody
    public String getFriendList(@RequestParam("id") long id) {
       User user = userService.getFriendListByMyId(id);
       return JSON.toJSONString(user);
    }
}
