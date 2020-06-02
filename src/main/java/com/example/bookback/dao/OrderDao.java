package com.example.bookback.dao;

import com.example.bookback.entity.Order;
import com.example.bookback.entity.OrderItem;
import com.example.bookback.entity.User;

import javax.xml.crypto.Data;
import java.util.List;

public interface OrderDao {
   // String placeOrder(List<Integer> orderList, Integer userId);

    Order  placeOrder(User user);

    List<Integer> getOrderKey(Integer userId);

   // List<OrderItem> getOneOrder(Integer orderId);

    List<Order> getAllOrders();

    Data getOrderTime(Integer orderId);

    Order getOrderById(Integer orderId);

    void addOredrItemForOrder(Order order, OrderItem orderItem);

    List<Order> getOrderByUserId(Integer userId);
}
