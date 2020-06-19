package com.example.bookback.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.bookback.entity.Book;
import com.example.bookback.entity.OrderItem;
import com.example.bookback.entity.Type;
import com.example.bookback.entity.User;
import com.example.bookback.service.BookService;
import com.example.bookback.service.OrderItemService;
import com.example.bookback.service.TypeService;
import com.example.bookback.service.UserService;
import com.example.bookback.utils.msgutils.Msg;
import com.example.bookback.utils.msgutils.MsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
public class SaleController {

    @Autowired
    private BookService bookService;
    @Autowired
    private OrderItemService orderItemService;
    @Autowired
    private UserService userService;

    // 获得所有orderItem
    @RequestMapping("/bookSale")
    public String bookSale() {
        System.out.println("bookSale");

        List<OrderItem> ans = orderItemService.getAllOrderItemInOrder();
        Iterator<OrderItem> it = ans.iterator();

        ArrayList<JSONObject> orderItemsJson = new ArrayList<JSONObject>();
        while (it.hasNext()) {
            OrderItem orderItem = (OrderItem) it.next();

            JSONObject model = new JSONObject();
            model.put("orderItemId", orderItem.getOrderItemId());
            model.put("bookId", orderItem.getBook().getBookId());
            model.put("userId", orderItem.getUser().getUserId());
            model.put("price", orderItem.getPrice());
            model.put("time", orderItem.getInOrder().getDate());
            model.put("number", orderItem.getNumber());
            orderItemsJson.add(model);
        }
        String orderItemsString = JSON.toJSONString(orderItemsJson, SerializerFeature.BrowserCompatible);
        System.out.println(orderItemsString);
        return orderItemsString;
    }

    // 获得id为userId的人的所有orderItem
    @RequestMapping("/myBookSale")
    public String myBookSale(@RequestParam(value="userId") Integer userId) {
        System.out.println("myBookSale");
        System.out.println("userId");

        List<OrderItem> ans = orderItemService.getAllOrderItemInOrderByUserId(userId);
        Iterator<OrderItem> it = ans.iterator();

        ArrayList<JSONObject> orderItemsJson = new ArrayList<JSONObject>();
        while (it.hasNext()) {
            OrderItem orderItem = (OrderItem) it.next();

            JSONObject model = new JSONObject();
            model.put("orderItemId", orderItem.getOrderItemId());
            model.put("bookId", orderItem.getBook().getBookId());
            model.put("userId", orderItem.getUser().getUserId());
            model.put("price", orderItem.getPrice());
            model.put("time", orderItem.getInOrder().getDate());
            model.put("number", orderItem.getNumber());
            orderItemsJson.add(model);
        }
        String orderItemsString = JSON.toJSONString(orderItemsJson, SerializerFeature.BrowserCompatible);
        System.out.println(orderItemsString);
        return orderItemsString;
    }

    //获得统计功能所需的所有书籍信息
    @GetMapping("/getBooksForStatistic")
    public String getBooksForStatistic() {
        System.out.println("getBooksForStatistic");
        List<Book> ans = bookService.getAllBooks();
        Iterator<Book> it = ans.iterator();

        ArrayList<JSONObject> booksJson = new ArrayList<JSONObject>();
        while (it.hasNext()) {
            Book book = (Book) it.next();
            JSONObject model = new JSONObject();
            model.put("bookId", book.getBookId());
            model.put("book", book.getName());
            model.put("author", book.getAuthor());
            model.put("stock", book.getInventory());

            model.put("price", book.getPrice());
            model.put("type", book.getType().getName());
            model.put("number", 0);
            booksJson.add(model);
        }

        return JSON.toJSONString(booksJson, SerializerFeature.BrowserCompatible);
    }

    // 获得所有用户信息 用于用户消费额统计
    @GetMapping("/getAllUserForStatistic")
    public String getAllUserForStatistic() {
        System.out.println("getAllUserForStatistic");
        List<User> users = userService.getAllUser();
        Iterator<User> it=users.iterator();
        ArrayList<JSONObject> usersJson = new ArrayList<JSONObject>();
        while (it.hasNext()) {
            User user=it.next();
            JSONObject model = new JSONObject();
            model.put("userId", user.getUserId());
            model.put("name",user.getName());
            model.put("price", 0);
            model.put("number", 0);
            usersJson.add(model);
        }

        return JSON.toJSONString(usersJson, SerializerFeature.BrowserCompatible);

    }


}

