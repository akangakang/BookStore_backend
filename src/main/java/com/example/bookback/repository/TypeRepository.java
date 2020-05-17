package com.example.bookback.repository;

import com.example.bookback.entity.Type;
import com.example.bookback.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TypeRepository extends JpaRepository<Type,Integer> {
    @Query("select a from Type a where a.name=:name")
    List<Type> findByName(String name);
}
