package com.example.bookback.service;

import com.example.bookback.entity.OrderItem;

import java.util.List;

public interface OrderItemService {

    List<OrderItem> getAllOrderItemInOrder();

    OrderItem getByUserAndBook(Integer userId, Integer bookId);

    void addOrderItem1(Integer userId, Integer bookId);

    void addOrderItem2(Integer userId, Integer bookId,Integer id);

    List<OrderItem> getCartItems(Integer userId);

    Integer addOrderItemByItemId(Integer itemId);

    Integer removeCartItem(Integer itemId);
}
