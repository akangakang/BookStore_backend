package com.example.bookback.dao;


import com.example.bookback.entity.User;
import com.example.bookback.utils.msgutils.Msg;

import java.util.Map;

public interface UserDao {

    User checkUser(String username, String password);

    Msg register(Map<String, String> params);

    User findById(Integer id);
}
