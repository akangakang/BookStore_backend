package com.example.bookback.daoimpl;

import com.example.bookback.dao.OrderItemDao;
import com.example.bookback.entity.*;
import com.example.bookback.repository.BookExtraRepository;
import com.example.bookback.repository.BookRepository;
import com.example.bookback.repository.OrderItemRepository;
import com.example.bookback.repository.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;

@Repository
public class OrderItemDaoImpl implements OrderItemDao {
    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    BookExtraRepository bookExtraRepository;
    @Override
    public OrderItem getByUserAndBook(Integer userId, Integer bookId) {
        return  orderItemRepository.getByUserAndBook(userId,bookId);
    }

    @Override

    public void addOderItem1(User user, Book book) {
      OrderItem orderItem=new OrderItem();

      orderItem.setPrice(book.getPrice());
      orderItem.setIsOrder(0);
      orderItem.setNumber(1);
      orderItem.setBook(book);
      orderItem.setUser(user);
      orderItemRepository.saveAndFlush(orderItem);



    }

    //已经有orderItem了 仅增加数量
    @Override
    public void addOderItem2(User user, Book book,Integer id) {

        OrderItem orderItem=orderItemRepository.findById(id).get();
        orderItem.setNumber(orderItem.getNumber()+1);
        orderItem.setPrice(book.getPrice());
        orderItemRepository.saveAndFlush(orderItem);


    }

    @Override
    public List<OrderItem> getCartItems(Integer userId) {

        List<OrderItem> orderItems= orderItemRepository.findByUser1(userId);
        Iterator<OrderItem> it =orderItems.iterator();

        while (it.hasNext())
        {
            OrderItem orderItem=it.next();
            Book book=orderItem.getBook();
            Integer id=book.getBookId();
            BookExtra bookExtra=bookExtraRepository.findById(id).get();
            book.setExtraCover(bookExtra);

            orderItem.setBook(book);
        }
        return orderItems;
    }

    @Override
    public Integer addOrderItemByItemId(Integer itemId){
       OrderItem orderItem=orderItemRepository.findById(itemId).get();
       orderItem.setNumber(orderItem.getNumber()+1);
        orderItemRepository.saveAndFlush(orderItem);
        System.out.println(orderItem.getNumber());
        return orderItem.getNumber();
    }

    @Override
    public Integer removeCartItem(Integer itemId) {
        OrderItem orderItem=orderItemRepository.findById(itemId).get();
       if(orderItem.getNumber()>1)
       {
           orderItem.setNumber(orderItem.getNumber()-1);
           orderItemRepository.saveAndFlush(orderItem);
           System.out.println(orderItem.getNumber());
           return orderItem.getNumber();
       }
       else {
           orderItemRepository.deleteById(itemId);
           return 0;
       }
    }

    @Override
    public List<OrderItem> findOrderItemByBook(Book book) {
        return orderItemRepository.findOrderItemByBook(book);
    }

    @Override
    public OrderItem findById(Integer id) {
        if(!orderItemRepository.findById(id).isPresent())
            return null;
        else return orderItemRepository.findById(id).get();
    }

    @Override
    public void placeInOrder(OrderItem orderItem, Order order) {

        orderItem.setInOrder(order);
        orderItem.setIsOrder(1);
        orderItemRepository.saveAndFlush(orderItem);
    }

    @Override
    public List<OrderItem> getOneOrder(Integer orderId) {
        List<OrderItem> orderItems= orderItemRepository.findByOrderId(orderId);
        Iterator<OrderItem> it =orderItems.iterator();

        while (it.hasNext())
        {
            OrderItem orderItem=it.next();
            Book book=orderItem.getBook();
            Integer id=book.getBookId();
            BookExtra bookExtra=bookExtraRepository.findById(id).get();
            book.setExtraCover(bookExtra);

            orderItem.setBook(book);
        }
        return orderItems;

    }


}
