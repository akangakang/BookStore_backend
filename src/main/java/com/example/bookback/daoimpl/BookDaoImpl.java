package com.example.bookback.daoimpl;

import com.example.bookback.dao.BookDao;
import com.example.bookback.entity.Book;
import com.example.bookback.entity.BookExtra;
import com.example.bookback.entity.Type;
import com.example.bookback.repository.BookExtraRepository;
import com.example.bookback.repository.BookRepository;
import com.example.bookback.repository.OrderItemRepository;
import com.example.bookback.repository.TypeRepository;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.hibernate.type.YesNoType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookExtraRepository bookExtraRepository;


    @Override
    public Book findOne(Integer id){
        Book book=bookRepository.getOne(id);
        BookExtra bookExtra=bookExtraRepository.findById(id).get();
        book.setExtraCover(bookExtra);
        return book;
    }


    @Override
    public List<Book> getBooks()
    {
      List<Book> books=bookRepository.getBooks();
        Iterator<Book> it=books.iterator();


        while (it.hasNext())
        {
            Book book=it.next();
            Integer id=book.getBookId();
            BookExtra bookExtra=bookExtraRepository.findById(id).get();


           // System.out.println(bookExtra.getId());
            book.setExtraCover(bookExtra);


        }
        return books;
    }

    @Override
    public List<Book> getBooksByType(Integer id) {
        List<Book> books=bookRepository.findByType(id);
        Iterator<Book> it=books.iterator();


        List<BookExtra> a=bookExtraRepository.findAll();
        System.out.println("size");
        System.out.println(a.size());
       // System.out.println(a.get(0).getId());
        //System.out.println(a.get(0).getImage());

        while (it.hasNext())
        {
            Book book=it.next();
            Integer bookId=book.getBookId();


            Optional<BookExtra> bookExtraOptional=bookExtraRepository.findById(bookId);

            if (!bookExtraOptional.isPresent())
            {
                System.out.println("no id in nosql");
                System.out.println(bookId);
            }
            else
            {
                BookExtra bookExtra=bookExtraOptional.get();
//                System.out.println(bookExtra.getId());
                book.setExtraCover(bookExtra);
            }



        }
        return books;
    }

    @Override
    public int editBook(Map<String, String> params, Type type) {
        int bookId= Integer.parseInt(params.get("key"));
        Book book=bookRepository.findById(bookId).get();


        book.setInventory(Integer.parseInt(params.get("stock")));
        book.setAuthor(params.get("author"));
        book.setName(params.get("book"));
        book.setDescription(params.get("description"));
        book.setIsbn(params.get("isbn"));
        book.setType(type);
        book.setPrice(Double.parseDouble(params.get("price")));
        book.setSale(Integer.parseInt(params.get("sale")));
        bookRepository.saveAndFlush(book);

        return 1;
    }

    @Override
    public List<Book> getAllBooks() {
        //return bookRepository.findAll();
        List<Book> books=bookRepository.findAll();
        Iterator<Book> it=books.iterator();


        while (it.hasNext())
        {
            Book book=it.next();
            Integer id=book.getBookId();
            BookExtra bookExtra=bookExtraRepository.findById(id).get();

            System.out.println(bookExtra.getId());
            book.setExtraCover(bookExtra);

        }
        return books;
    }

    @Override
    public Book addBook(Map<String, String> params, Type type) {
        Book book=new Book();

        book.setInventory(Integer.parseInt(params.get("stock")));
        book.setAuthor(params.get("author"));
        book.setName(params.get("book"));
        book.setDescription(params.get("description"));
        book.setIsbn(params.get("isbn"));
        book.setPrice(Double.parseDouble(params.get("price")));
       // book.setImage(params.get("cover"));


        book.setSale(Integer.parseInt(params.get("sale")));
        //List<Type> types=typeRepository.findByName(params.get("type"));
        book.setType(type);

        bookRepository.saveAndFlush(book);


        BookExtra bookExtra=new BookExtra();
        bookExtra.setId(book.getBookId());
        bookExtra.setImage(params.get("cover"));
        bookExtraRepository.save(bookExtra);
        book.setExtraCover(bookExtra);

        bookRepository.saveAndFlush(book);
        return book;
    }

    @Override
    public void deleteById(Integer id) {

        BookExtra bookExtra=bookRepository.findById(id).get().getExtraCover();

        bookExtraRepository.delete(bookExtra);
        bookRepository.deleteById(id);
    }

    @Override
    public void editBookInventory(Book book, Integer num) {
        book.setInventory(book.getInventory()-num);
        bookRepository.saveAndFlush(book);

    }

    @Override
    public List<Book> findByType(Integer typeId) {
        List<Book>books=bookRepository.findByType(typeId);
        Iterator<Book> it=books.iterator();


        while (it.hasNext())
        {
            Book book=it.next();
            Integer id=book.getBookId();
            BookExtra bookExtra=bookExtraRepository.findById(id).get();

           System.out.println(bookExtra.getId());
           book.setExtraCover(bookExtra);

    }
        return books;
    }

    @Override
    public int editImg(Map<String, String> params) {
        int bookId=Integer.parseInt(params.get("key"));
        String cover=params.get("img");

        System.out.println(cover);
        Book book=bookRepository.findById(bookId).get();
        BookExtra bookExtra=bookExtraRepository.findById(bookId).get();

        bookExtra.setImage(cover);
        book.setExtraCover(bookExtra);
        bookExtraRepository.save(bookExtra);
        bookRepository.saveAndFlush(book);

        return 1;

    }


}
