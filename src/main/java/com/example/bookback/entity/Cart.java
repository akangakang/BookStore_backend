package com.example.bookback.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "CARTS",schema = "mybookstore")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "cartId")
public class Cart {
    private int bookId;
    private int cartId;
    private int userId;

    public Cart(){}
    @Id
    @Column(name = "cartid")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public int getCartId(){
        return cartId;
    }
    private void setCartId(int id) {
        this.cartId=id;
    }


    public int getBookId(){
        return bookId;
    }
    private void setBookId(int id) {
        this.bookId=id;
    }

    public Integer getUserId(){
        return userId;
    }
    private  void setUserId(Integer userId){this.userId=userId;}

}
