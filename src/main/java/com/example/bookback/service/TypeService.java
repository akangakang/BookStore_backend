package com.example.bookback.service;

import com.example.bookback.entity.Book;
import com.example.bookback.entity.Type;
import com.example.bookback.utils.msgutils.Msg;

import java.util.List;
import java.util.Map;

public interface TypeService {
    List<Type> findAll();

    Msg editType(Map<String, String> params);

    Msg deleteType(Integer id);

    Type addType(Map<String, String> params);


}
