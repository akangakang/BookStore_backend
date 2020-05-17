package com.example.bookback.service;

import com.example.bookback.entity.Book;
import com.example.bookback.utils.msgutils.Msg;

import java.util.List;
import java.util.Map;

public interface BookService {

    Book findBookById(Integer id);

    List<Book> getBooks();

    List<Book> getBooksByType(Integer id);

    Msg editBook(Map<String, String> params);

    Msg deleteBook(Integer id);

    List<Book> getAllBooks();

    Book addBook(Map<String, String> params);
}