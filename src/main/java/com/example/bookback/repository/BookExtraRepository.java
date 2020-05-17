package com.example.bookback.repository;

import com.example.bookback.entity.Book;
import com.example.bookback.entity.BookExtra;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookExtraRepository extends MongoRepository<BookExtra, Integer> {

}
