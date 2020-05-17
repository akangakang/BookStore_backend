package com.example.bookback.serviceimpl;

import com.example.bookback.controller.OderItemController;
import com.example.bookback.dao.BookDao;
import com.example.bookback.dao.OrderDao;
import com.example.bookback.dao.OrderItemDao;
import com.example.bookback.dao.UserDao;
import com.example.bookback.entity.Book;
import com.example.bookback.entity.Order;
import com.example.bookback.entity.OrderItem;
import com.example.bookback.entity.User;
import com.example.bookback.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;

    @Autowired
    OrderItemDao orderItemDao;

    @Autowired
    UserDao userDao;

    @Autowired
    BookDao bookDao;


    @Override
    public String placeOrder(List<Integer> orderList, Integer userId) {
        Iterator<Integer> it=orderList.iterator();
        System.out.println("place order");

        System.out.println(orderList);

        //先检查有无不合理的的数据
        while (it.hasNext())
        {
            Integer orderitemKey = it.next();

            if(orderItemDao.findById(orderitemKey)==null)
            {
                return "失败：购物车内未找到该项目";
            }
            else {
                Book book=orderItemDao.findById(orderitemKey).getBook();
                if(book.getInventory()<orderItemDao.findById(orderitemKey).getNumber())
                {
                    return "失败："+book.getName()+"库存不足,"+"仅剩"+book.getInventory()+"本";
                }
            }
        }



        User user=userDao.findById(userId);
        if(user==null) return "失败：不存在该用户";





        Order order=orderDao.placeOrder(user);
        Iterator<Integer> it2=orderList.iterator();

        while(it2.hasNext())
        {
            Integer orderItemKey=it2.next();
            System.out.println("orderItemKey :");
            System.out.println(orderItemKey);



            OrderItem orderItem=orderItemDao.findById(orderItemKey);
            orderItemDao.placeInOrder(orderItem,order);
            orderDao.addOredrItemForOrder(order,orderItem);


            //减少库存
            int num=orderItem.getNumber();
            Book book = orderItem.getBook();
            bookDao.editBookInventory(book,num);

        }

        System.out.println("place order 成功");
        return "成功";

        //return orderDao.placeOrder(orderList,userId);
    }

    @Override
    public List<Integer> getOrderKey(Integer userId) {
        return orderDao.getOrderKey(userId);
    }

    @Override
    public List<OrderItem> getOneOrder(Integer orderId) {
        return orderItemDao.getOneOrder(orderId);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }

    @Override
    public Data getOrderTime(Integer orderId) {
        return orderDao.getOrderTime(orderId);
    }

    @Override
    public Order getOrderById(Integer orderId) {
        return orderDao.getOrderById(orderId);
    }
}
