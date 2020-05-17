package com.example.bookback.repository;

import com.example.bookback.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(value = "from User where name = :username and password = :password")
    User checkUser(@Param("username") String username, @Param("password") String password);

    @Query("select a from User a where a.name=:username")
    List<User> checkUsername(String username);
}
