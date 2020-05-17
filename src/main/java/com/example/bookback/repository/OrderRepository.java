package com.example.bookback.repository;


import com.example.bookback.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

    @Query("select o.orderId from Order o where o.user.userId=:userId")
    List<Integer> findByUserId(Integer userId);

    @Query("select o from Order o where o.user.userId=:userId")
    List<Order> findByUserIdForOrders(Integer userId);

    @Query("select o.date from Order o where o.orderId=:orderId")
    Data findOrderTime(Integer orderId);
}
