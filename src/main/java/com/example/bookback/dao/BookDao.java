package com.example.bookback.dao;

import com.example.bookback.entity.Book;
import com.example.bookback.entity.Type;
import com.example.bookback.utils.msgutils.Msg;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;

import java.util.List;
import java.util.Map;

public interface BookDao {
    Book findOne(Integer id);

    List<Book> getBooks();

    List<Book> getBooksByType(Integer id);

    int editBook(Map<String, String> params, Type type);

//    Msg deleteBook(Integer id);

    List<Book> getAllBooks();

    Book addBook(Map<String, String> params,Type type);

    void deleteById(Integer id);

    void editBookInventory(Book bookId, Integer num);

    List<Book> findByType(Integer typeId);

    int editImg(Map<String, String> params);
}
