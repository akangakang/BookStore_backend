package com.example.bookback.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.bookback.entity.User;
import com.example.bookback.service.UserService;
import com.example.bookback.utils.msgutils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/checkUser")
    public User checkUser(@RequestParam(value="username" ,required = false) String username , @RequestParam(value = "password",required = false) String password){
        System.out.println("check user");
        System.out.println(username);
        System.out.println(password);
        return userService.checkUser(username, password);
    }

    @RequestMapping("/register")
    public Msg register(@RequestBody Map<String, String> params){
        System.out.println("register");
        String username=params.get("username");
        String password=params.get("password");

        System.out.println(username);
        System.out.println(password);
        return userService.register(params);
    }

    @RequestMapping("/getAllUser")
    public List<User> getAllUser(){
        System.out.println("getAllUser");
        return userService.getAllUser();
    }

    @RequestMapping("/editUser")
    public Msg editUser(@RequestBody Map<String, String> params){
        System.out.println("editUser");
        System.out.println(params);

        Msg ans=userService.editUser(params);
        return ans;
    }


}
