package com.example.bookback.dao;

import com.example.bookback.entity.*;

import java.util.List;

public interface OrderItemDao {
    OrderItem getByUserAndBook(Integer userId, Integer bookId);

    void addOderItem1(User user, Book book);

    void addOderItem2(User user, Book book,Integer id);

    List<OrderItem> getCartItems(Integer userId);

    Integer addOrderItemByItemId(Integer itemId);

    Integer removeCartItem(Integer itemId);

    List<OrderItem> findOrderItemByBook(Book book);

    OrderItem findById(Integer id);

    void placeInOrder(OrderItem orderItem,Order order);

    List<OrderItem> getOneOrder(Integer orderId);

    List<OrderItem> getAllOrderItemInOrder();
}
