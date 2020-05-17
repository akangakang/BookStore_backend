package com.example.bookback.serviceimpl;

import com.example.bookback.dao.BookDao;
import com.example.bookback.dao.OrderItemDao;
import com.example.bookback.dao.UserDao;
import com.example.bookback.entity.Book;
import com.example.bookback.entity.OrderItem;
import com.example.bookback.entity.User;
import com.example.bookback.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    OrderItemDao orderItemDao;
    @Autowired
    BookDao bookDao;
    @Autowired
    UserDao userDao;



    @Override
    public OrderItem getByUserAndBook(Integer userId, Integer bookId) {
        return orderItemDao.getByUserAndBook(userId,bookId);
    }

    @Override
    public void addOrderItem1(Integer userId, Integer bookId) {

        Book book = bookDao.findOne(bookId);
        User user=userDao.findById(userId);


        orderItemDao.addOderItem1(user,book);
//        orderItem.setPrice(book.getPrice());
//        orderItem.setIsOrder(0);
//        orderItem.setNumber(1);
//        orderItem.setBook(book);
//        orderItem.setUser(user);
//        orderItemRepository.saveAndFlush(orderItem);
        //orderItemDao.addOderItem1(userId,bookId);
    }

    @Override
    public void addOrderItem2(Integer userId, Integer bookId,Integer id) {
        Book book = bookDao.findOne(bookId);
        User user=userDao.findById(userId);;

        orderItemDao.addOderItem2(user,book,id);
    }

    @Override
    public List<OrderItem> getCartItems(Integer userId) {
        return orderItemDao.getCartItems(userId);
    }

    @Override
    public Integer addOrderItemByItemId(Integer itemId) {
        return orderItemDao.addOrderItemByItemId(itemId);
    }

    @Override
    public Integer removeCartItem(Integer itemId) {
        return orderItemDao.removeCartItem(itemId);
    }
}
