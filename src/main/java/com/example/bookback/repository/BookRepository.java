package com.example.bookback.repository;
import com.example.bookback.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

   //@Query(value = "select b.author as author,b.bookId as key, b.image as cover,b.isbn as isbn,b.inventory as stock,b.name as book from Book b")

   @Query("select b from Book b where b.bookId>-1 and b.sale=1")
   List<Book> getBooks();

   @Query(value = "select b from Book b where b.type.typeid=:id")
    List<Book> findByType(Integer id);
    //  @Query("select b from Book b")

}
