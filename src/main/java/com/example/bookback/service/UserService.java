package com.example.bookback.service;

import com.example.bookback.entity.User;
import com.example.bookback.utils.msgutils.Msg;

import java.util.List;
import java.util.Map;

public interface UserService {
    User checkUser(String username, String password);

    Msg register(Map<String, String> params);

    List<User> getAllUser();

    Msg editUser(Map<String, String> params);
}
