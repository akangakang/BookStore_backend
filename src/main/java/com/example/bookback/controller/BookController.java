package com.example.bookback.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.bookback.daoimpl.BookDaoImpl;
import com.example.bookback.entity.Book;
import com.example.bookback.entity.Type;
import com.example.bookback.service.BookService;
import com.example.bookback.service.TypeService;
import com.example.bookback.utils.msgutils.Msg;
import com.example.bookback.utils.msgutils.MsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private TypeService typeService;


    @GetMapping("/getBooks")
    public String getBooks() {
        System.out.println("get books");
        List<Book> ans=bookService.getBooks();
        Iterator<Book> it =ans.iterator();

        ArrayList<JSONObject> booksJson = new ArrayList<JSONObject>();
        while (it.hasNext()) {
            Book book = (Book) it.next();
            JSONObject model=new JSONObject();
            model.put("key",book.getBookId());
            model.put("book",book.getName());
            model.put("author",book.getAuthor());
            model.put("isbn",book.getIsbn());
            model.put("stock",book.getInventory());
            model.put("description",book.getDescription());
            model.put("cover",book.getExtraCover().getImage());
            model.put("price",book.getPrice());
            model.put("type",book.getType().getName());
            model.put("typeKey",book.getType().getTypeid());
            booksJson.add(model);
    }
    String  booksString = JSON.toJSONString(booksJson, SerializerFeature.BrowserCompatible);
        System.out.println(booksString);
    return booksString;
    }


    @GetMapping("/getBookDetail")
    public Book getBook(@RequestParam("id") Integer id){
        System.out.println("get book");
        System.out.println(id);
        return bookService.findBookById(id);
    }

    @GetMapping("/getTypes")
    public List<Type> getType(){
        System.out.println("get types");

        List<Type> ans=typeService.findAll();
        System.out.println(ans);
        return ans;
    }

    @GetMapping("/getBooksByType")
    public List<Book> getBooksByType(@RequestParam("id") Integer id){
        System.out.println("getBooksByType");
        System.out.println(id);
        List<Book> ans=bookService.getBooksByType(id);

        return ans;
    }

    @GetMapping("/getBooksAllInfo")
    public String getBooksAllInfo() {
        System.out.println("getBooksAllInfo");
        List<Book> ans=bookService.getAllBooks();
        Iterator<Book> it =ans.iterator();

        ArrayList<JSONObject> booksJson = new ArrayList<JSONObject>();
        while (it.hasNext()) {
            Book book = (Book) it.next();

            JSONObject model=new JSONObject();
            model.put("key",book.getBookId());
            model.put("book",book.getName());
            model.put("author",book.getAuthor());
            model.put("isbn",book.getIsbn());
            model.put("stock",book.getInventory());
            model.put("cover",book.getExtraCover().getImage());
            model.put("price",book.getPrice());
            model.put("type",book.getType().getName());
            model.put("typeKey",book.getType().getTypeid());
            model.put("description",book.getDescription());
            model.put("sale",book.getSale());
            booksJson.add(model);
        }
        String  booksString = JSON.toJSONString(booksJson, SerializerFeature.BrowserCompatible);
//        System.out.println(booksString);
        return booksString;
    }
    @GetMapping("/getBooksAllInfoW")
    public String getBooksAllInfoW() {
        System.out.println("getBooksAllInfoW");
        List<Book> ans=bookService.getAllBooks();
        Iterator<Book> it =ans.iterator();

        ArrayList<JSONObject> booksJson = new ArrayList<JSONObject>();
        for(int i=0;i<10 && it.hasNext();i++){
            Book book = (Book) it.next();

            JSONObject model=new JSONObject();
            model.put("key",book.getBookId());
            model.put("book",book.getName());
            model.put("author",book.getAuthor());
            model.put("isbn",book.getIsbn());
            model.put("stock",book.getInventory());
            model.put("cover",book.getExtraCover().getImage());
            model.put("price",book.getPrice());
            model.put("type",book.getType().getName());
            model.put("typeKey",book.getType().getTypeid());
            model.put("description",book.getDescription());
            model.put("sale",book.getSale());
            booksJson.add(model);
        }
        //        System.out.println(booksString);
        return JSON.toJSONString(booksJson, SerializerFeature.BrowserCompatible);
    }

    @RequestMapping("/editBook")
    public Msg editBook(@RequestBody Map<String, String> params){
        System.out.println("editBook");
        System.out.println(params);

        Msg ans=bookService.editBook(params);
        return ans;
    }

    @RequestMapping("/editType")
    public Msg editType(@RequestBody Map<String, String> params){
        System.out.println("editType");
        System.out.println(params);

        return typeService.editType(params);
    }

    @RequestMapping("/editImg")
    public Msg editImg(@RequestBody Map<String, String> params){
        System.out.println("editImg");
        System.out.println(params);

        if(bookService.editImg(params)>0)
        {
            return MsgUtil.makeMsg(1,"传图片成功");
        }
        else {
            return MsgUtil.makeMsg(0,"上传图片失败");
        }
    }

    @RequestMapping("/deleteBook")
    public Msg deleteBook(@RequestParam("id") Integer id){
        System.out.println("deleteBook");
        System.out.println(id);

        Msg ans=bookService.deleteBook(id);
        System.out.println(ans);
        return ans;
    }

    @RequestMapping("/deleteType")
    public Msg deleteType(@RequestParam("id") Integer id){
        System.out.println("deleteType");
        System.out.println(id);

        Msg ans=typeService.deleteType(id);
        System.out.println(ans);
        return ans;
    }

    @RequestMapping("/addType")
    public Type addType(@RequestBody Map<String, String> params){
        System.out.println("addType");

        Type ans=typeService.addType(params);
        System.out.println(ans);
       return ans;
    }

    @RequestMapping("/addBook")
    public JSONObject addBook(@RequestBody Map<String, String> params){
        System.out.println("addBook");

        Book book=bookService.addBook(params);
        JSONObject model=new JSONObject();
        model.put("key",book.getBookId());
        model.put("book",book.getName());
        model.put("author",book.getAuthor());
        model.put("isbn",book.getIsbn());
        model.put("stock",book.getInventory());
        model.put("cover",book.getExtraCover().getImage());
        model.put("price",book.getPrice());
        model.put("type",book.getType().getName());
        model.put("description",book.getDescription());
        model.put("sale",book.getSale());
        System.out.println(book);

        return model;
    }


}
