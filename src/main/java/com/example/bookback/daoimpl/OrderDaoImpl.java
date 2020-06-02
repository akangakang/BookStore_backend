package com.example.bookback.daoimpl;

import com.example.bookback.dao.OrderDao;
import com.example.bookback.entity.Book;
import com.example.bookback.entity.Order;
import com.example.bookback.entity.OrderItem;
import com.example.bookback.entity.User;
import com.example.bookback.repository.BookRepository;
import com.example.bookback.repository.OrderItemRepository;
import com.example.bookback.repository.OrderRepository;
import com.example.bookback.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Repository
public class OrderDaoImpl implements OrderDao {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order placeOrder(User user) {
        Order order=new Order();
        order.setUser(user);

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            //使用SimpleDateFormat的parse()方法生成Date
            date = sf.parse(sf.format(c.getTime()));
            //打印Date
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        order.setDate(date);

        orderRepository.saveAndFlush(order);
        return order;
    }


    @Override
    public List<Integer> getOrderKey(Integer userId) {
        return orderRepository.findByUserId(userId);


    }

//    @Override
//    public List<OrderItem> getOneOrder(Integer orderId) {
//
//        return orderItemRepository.findByOrderId(orderId);
//    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Data getOrderTime(Integer orderId) {
        Data ans=orderRepository.findOrderTime(orderId);
        System.out.println(ans);
        return ans;
    }

    @Override
    public Order getOrderById(Integer orderId) {
        return orderRepository.getOne(orderId);
    }

    @Override
    public void addOredrItemForOrder(Order order, OrderItem orderItem) {
        order.addMyOrder(orderItem);
    }

    @Override
    public List<Order> getOrderByUserId(Integer userId) {
        return orderRepository.findByUserIdForOrders(userId);
    }
}
