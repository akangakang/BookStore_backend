package com.example.bookback.repository;

import com.example.bookback.entity.Book;
import com.example.bookback.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem,Integer> {
    @Query("SELECT o FROM OrderItem o where o.book.bookId=:bookId and o.user.userId=:userId and o.isOrder=0")
    OrderItem getByUserAndBook(Integer userId, Integer bookId);

    @Query("SELECT o from OrderItem o where o.user.userId=:userId and o.isOrder=0")
    List<OrderItem> findByUser1(Integer userId);

    @Query("SELECT o from OrderItem o where o.inOrder.orderId=:orderId")
    List<OrderItem> findByOrderId(Integer orderId);



    List<OrderItem> findOrderItemByBook(Book book);


    @Query("SELECT o from OrderItem o where o.isOrder=1")
    List<OrderItem> getAllOrderItemInOrder();
}
