package com.example.bookback.dao;

import com.example.bookback.entity.Type;
import com.example.bookback.utils.msgutils.Msg;

import java.util.List;
import java.util.Map;

public interface TypeDao {
    List<Type> findAll();

    Msg editType(Map<String, String> params);

    Type findById(Integer id);
  // Msg deleteType(Integer id);

    Type addType(Map<String, String> params);

    List<Type> findByName(String name);

    void deleteById(Integer id);
}
