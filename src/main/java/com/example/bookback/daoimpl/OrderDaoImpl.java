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
//    @Autowired
//    OrderItemRepository orderItemRepository;
//
//    @Override
//    public String placeOrder(List<Integer> orderList, Integer userId)  {
//        Iterator<Integer> it=orderList.iterator();
//        System.out.println("place order");
//
//        System.out.println(orderList);
//
//        //先检查有无不合理的的数据
//        while (it.hasNext())
//        {
//            Integer orderitemKey = it.next();
//
//            if(!orderItemRepository.findById(orderitemKey).isPresent())
//            {
//                return "失败：购物车内未找到该项目";
//            }
//            else {
//                Book book=orderItemRepository.findById(orderitemKey).get().getBook();
//                if(book.getInventory()<orderItemRepository.findById(orderitemKey).get().getNumber())
//                {
//                    return "失败："+book.getName()+"库存不足,"+"仅剩"+book.getInventory()+"本";
//                }
//            }
//        }
//
//        Order order=new Order();
//
//        User user=userRepository.findById(userId).get();
//        order.setUser(user);
//
//        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//
//        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
//        Calendar c = Calendar.getInstance();
//        Date date = null;
//        try {
//            //使用SimpleDateFormat的parse()方法生成Date
//            date = sf.parse(sf.format(c.getTime()));
//            //打印Date
//            System.out.println(date);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        order.setDate(date);
//
//
//        Iterator<Integer> it2=orderList.iterator();
//        orderRepository.saveAndFlush(order);
//        while(it2.hasNext())
//        {
//            Integer orderItemKey=it2.next();
//            System.out.println("orderItemKey :");
//            System.out.println(orderItemKey);
//
//            OrderItem orderItem=orderItemRepository.findById(orderItemKey).get();
//            order.addMyOrder(orderItem);
//            orderItem.setInOrder(order);
//            orderItem.setIsOrder(1);
//
//            //减少库存
//            int num=orderItem.getNumber();
//            Book book = bookRepository.findById(orderItemRepository.findById(orderItemKey).get().getNumber()).get();
//            book.setInventory(book.getInventory()-num);
//            bookRepository.saveAndFlush(book);
//            orderItemRepository.saveAndFlush(orderItem);
//        }
//        orderRepository.saveAndFlush(order);
//        System.out.println("place order 成功");
//        return "成功";
//
//
//
//    }

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
}
