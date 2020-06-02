package com.example.bookback.entity;


import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.Id;

@Document(collection = "bookcover")
public class BookExtra {
    public Integer id;
    private String image;

    @Id
   // @Column(name = "_id")
    public Integer getId(){return id;}
    public void setId(Integer id){this.id=id;}

    @Column(name = "image")
    public String getImage(){return image;}
    public void setImage(String image){this.image=image;}

}
