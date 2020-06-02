package com.example.bookback.daoimpl;

import com.example.bookback.dao.UserDao;
import com.example.bookback.entity.Book;
import com.example.bookback.entity.User;
import com.example.bookback.repository.BookRepository;
import com.example.bookback.repository.UserRepository;
import com.example.bookback.utils.msgutils.Msg;
import com.example.bookback.utils.msgutils.MsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    UserRepository userRepository;


    @Override
    public User checkUser(String username, String password){

        return userRepository.checkUser(username,password);
    }

    @Override
    public Msg register(Map<String, String> params) {
        if(userRepository.checkUsername(params.get("username")).size()>0)
        {
            return MsgUtil.makeMsg(0,"注册失败：用户名已被占用");
        }
      //  User user=new User(params.get("username"),params.get("nickname"),params.get("tel"),params.get("address"),params.get("email"),params.get("password"));
        User user=new User();
        user.setAddress(params.get("address"));
        user.setEmail(params.get("email"));
        user.setName(params.get("username"));
        user.setNickname(params.get("nickname"));
        user.setPassword(params.get("password"));
        user.setUserType(0);
        user.setTel(params.get("tel"));
        userRepository.saveAndFlush(user);
        return MsgUtil.makeMsg(1,"注册成功");

    }

    @Override
    public User findById(Integer id) {
        if(!userRepository.findById(id).isPresent())
        {
            return null;
        }
        else return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAllUser() {
        return  userRepository.findAll();
    }

    @Override
    public int editUser(Map<String, String> params) {
        int userId= Integer.parseInt(params.get("userId"));
        User user=userRepository.findById(userId).get();
        user.setAddress(params.get("address"));
        user.setEmail(params.get("email"));
        user.setName(params.get("name"));
        user.setNickname(params.get("nickname"));
        user.setPassword(params.get("password"));
        user.setTel(params.get("tel"));
        user.setIsBanned(Integer.parseInt(params.get("isBanned")));
        user.setUserType(Integer.parseInt(params.get("userType")));
        userRepository.saveAndFlush(user);

        return 1;
    }


}
