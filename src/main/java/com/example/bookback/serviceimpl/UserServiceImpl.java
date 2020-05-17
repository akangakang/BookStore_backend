package com.example.bookback.serviceimpl;

import com.example.bookback.dao.UserDao;
import com.example.bookback.entity.User;
import com.example.bookback.service.UserService;
import com.example.bookback.utils.msgutils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User checkUser(String username, String password){
        return userDao.checkUser(username,password);


    }

    @Override
    public Msg register(Map<String, String> params) {
        return userDao.register(params);
    }


}
