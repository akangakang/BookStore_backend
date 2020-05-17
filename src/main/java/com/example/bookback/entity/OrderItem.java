package com.example.bookback.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "ORDERITEMS")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "orderItemId")
public class OrderItem {
    private int orderItemId;
    private Order inOrder;
    private Double price;
    private int number;
    private int isOrder;
    private Book book;
    private User user;


    @Id
    @Column(name = "orderitemid")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public int getOrderItemId(){
        return orderItemId;
    }
    private void setOrderItemId(int id) {
        this.orderItemId=id;
    }

    @ManyToOne
    @JoinColumn(name = "orderid")
    public Order getInOrder(){return inOrder;}
    public void setInOrder(Order order){this.inOrder=order;}

    public Double getPrice(){return price;}
    public void setPrice(Double price){this.price=price;}

    @Column(name = "number")
    public int getNumber(){return number;}
    public void setNumber(int n){this.number=n;}

    @Column(name = "isorder")
    public int getIsOrder(){return isOrder;}
    public void setIsOrder(int isOrder){this.isOrder=isOrder;}

    @ManyToOne
    @JoinColumn(name="bookid")
    public Book getBook(){return book;}
    public void setBook(Book book){this.book=book;}

    @ManyToOne
    @JoinColumn(name = "userid")
    public User getUser(){return user;}
    public void  setUser(User user){this.user=user;}
}
