package com.example.bookback.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ORDERS")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "orderId")
public class Order {
    private int orderId;
    private User user;
    private Date date;

    private Set<OrderItem> myOrder=new HashSet<OrderItem>();

    @Id
    @Column(name = "orderid")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public int getOrderId(){
        return orderId;
    }
    private void setOrderId(int id) {
        this.orderId=id;
    }

    @ManyToOne
    @JoinColumn(name = "userid")
    public User getUser(){return user;}
    public void setUser(User user){this.user=user;}

    @Temporal(TemporalType.TIMESTAMP)
    public Date getDate(){return date;}
    public void setDate(Date date){this.date=date;}

    @OneToMany(mappedBy = "inOrder")
    public Set<OrderItem> getMyOrder(){return myOrder;}
    public void setMyOrder(Set<OrderItem> o){this.myOrder=o;}
    public void addMyOrder(OrderItem orderItem) {
        this.myOrder.add(orderItem);
    }
}
