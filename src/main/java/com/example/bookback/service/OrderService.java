package com.example.bookback.service;

import com.example.bookback.entity.Order;
import com.example.bookback.entity.OrderItem;

import javax.xml.crypto.Data;
import java.util.List;

public interface OrderService {
    String placeOrder(List<Integer> orderList, Integer userId);

    List<Integer> getOrderKey(Integer userId);

    List<OrderItem> getOneOrder(Integer itemId);

    List<Order> getAllOrders();

    Data getOrderTime(Integer orderId);

    Order getOrderById(Integer orderId);
}
