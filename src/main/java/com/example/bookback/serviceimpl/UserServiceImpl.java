package com.example.bookback.serviceimpl;

import com.example.bookback.dao.UserDao;
import com.example.bookback.entity.Book;
import com.example.bookback.entity.Type;
import com.example.bookback.entity.User;
import com.example.bookback.service.UserService;
import com.example.bookback.utils.msgutils.Msg;
import com.example.bookback.utils.msgutils.MsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public Msg editUser(Map<String, String> params) {

        if(userDao.editUser(params)==1)
        {
            return MsgUtil.makeMsg(1,"修改成功");
        }
        else return MsgUtil.makeMsg(0,"修改失败");
//        book.setInventory(Integer.parseInt(params.get("stock")));
//        book.setAuthor(params.get("author"));
//        book.setName(params.get("book"));
//        book.setDescription(params.get("description"));
//        book.setIsbn(params.get("isbn"));
//        book.setType(type.get(0));
//        book.setPrice(Double.parseDouble(params.get("price")));
//        bookRepository.saveAndFlush(book);
//
//
//        return bookDao.editBook(params);
    }


}
