package com.example.bookback.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "TYPES",schema = "mybookstore")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "typeid")
public class Type {
    private int typeid;
    private String name;
    private String description;

    @Id
    @Column(name = "typeid")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public int getTypeid(){
        return typeid;
    }
    private void setTypeid(int id) {
        this.typeid=id;
    }

    public String getName(){return name;}
    public void setName(String name){this.name=name;}

    public String getDescription(){return description;}
    public void setDescription(String description){this.description=description;}

}
