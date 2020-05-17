package com.example.bookback.entity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "BOOKS",schema = "mybookstore")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "bookId")
public class Book {

    private int bookId;
    private String isbn;
    private String name;
    private Type type;
    private String author;
    private Double price;
    private String description;
    private Integer inventory;
   // private String image;
    private Integer sale;

//     private List<User> inCart = new ArrayList<>();



    public Book(){}
    public Book(String isbn,String name,Type type,String author,Double price,String description,Integer inventory,String image)
    {

        this.isbn=isbn;
        this.name=name;
        this.author=author;
        this.description=description;
        //this.image=image;
        this.type=type;
        this.price=price;
        this.inventory=inventory;
    }

    //    @GeneratedValue(generator = "increment")
//    @GenericGenerator(name = "increment", strategy = "increment")
    @Id
    @Column(name = "bookid")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public int getBookId(){
        return bookId;
    }
    private void setBookId(int id) {
        this.bookId=id;
    }

//    public String getImage(){return image;}
//    public void setImage(String image){this.image=image;}

    public String getIsbn(){return isbn;}
    public void setIsbn(String isbn){this.isbn=isbn;}

    public String getName(){return name;}
    public void setName(String name){this.name=name;}

    @ManyToOne
    @JoinColumn(name = "typeid")
    public Type getType(){return type;}
    public void setType(Type type){this.type=type;}

    public String getAuthor(){return author;}
    public void setAuthor(String author){this.author=author;}

    public String getDescription(){return description;}
    public void setDescription(String description){this.description=description;}

   public Double getPrice(){return price;}
   public void setPrice(Double price){this.price=price;}

   public Integer getInventory(){return inventory;}
   public void setInventory(Integer inventory){this.inventory=inventory;}

   public Integer getSale(){return sale;}
   public void setSale(Integer sale){this.sale=sale;}

//    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
//    @JoinTable(name = "CARTS",
//            joinColumns = @JoinColumn(name = "bookId", referencedColumnName = "bookId"),
//            inverseJoinColumns = @JoinColumn(name = "userId", referencedColumnName = "userId"))
//    @ManyToMany(mappedBy = "myCart", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
//    public List<User> getInCart(){return inCart;}
//    public void setInCart(List<User> myCart){this.inCart=myCart;}
//    public void addInCart(User user){this.inCart.add(user);}
//

    private BookExtra extraCover;
    @Transient
    public BookExtra getExtraCover(){
        return extraCover;
    }
    public void setExtraCover(BookExtra icon) {
        this.extraCover = icon;
    }
}
