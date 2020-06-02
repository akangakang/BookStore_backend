package com.example.bookback.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "USERS")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "userId")
public class User {

    private int userId;
    private String nickname;
    private String name;
    private String tel;
    private String address;
    private String email;
    private String password;
    private int userType;
    private int isBanned;

   //private List<Book> myCart=new ArrayList<>();

    public User(){}
    public User(String name,String nickname,String tel,String address,String email,String password)
    {
        this.address=address;
        this.name=name;
        this.email=email;
        this.nickname=nickname;
        this.tel=tel;
        this.password=password;
        this.userType=0;
        this.isBanned=0;
    }
    @Id
    @Column(name = "userid")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public Integer getUserId(){
        return userId;
    }
    private  void setUserId(Integer userId){this.userId=userId;}

    public String getNickname(){return nickname;}
    public void setNickname(String nickname){this.nickname=nickname;}

    public String getName(){return name;}
    public void setName(String name){this.name=name;}

    public String getTel(){return tel;}
    public void setTel(String tel){this.tel=tel;}

    public String getAddress(){return address;}
    public void setAddress(String address){this.address=address;}

    public String getEmail(){return email;}
    public void  setEmail(String eMail){this.email=eMail;}

    public String getPassword(){return password;}
    public void setPassword(String password){this.password=password;}

    @Column(name = "usertype")
    public int getUserType(){return userType;}
    public void setUserType(int userType){this.userType=userType;}

    @Column(name = "isbanned")
    public int getIsBanned(){return isBanned;}
    public void setIsBanned(int isBanned){this.isBanned=isBanned;}
   // @ManyToMany(mappedBy = "inCart", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)

//    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
//    @JoinTable(name = "CARTS",
//            joinColumns = @JoinColumn(name = "bookId", referencedColumnName = "userId"),
//            inverseJoinColumns = @JoinColumn(name = "userId", referencedColumnName = "bookId"))
//    public List<Book> getMyCart(){return myCart;}
//    public void setMyCart(List<Book> cart){this.myCart=cart;}
//    public void addMyCart(Book book){this.myCart.add(book);}


}
