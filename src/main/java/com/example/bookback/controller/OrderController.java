package com.example.bookback.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.bookback.entity.Order;
import com.example.bookback.entity.OrderItem;
import com.example.bookback.service.OrderItemService;
import com.example.bookback.service.OrderService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping("/placeOrder")
    public String placeOrder(@RequestBody List<Integer> orderList, @RequestParam(value="userId") Integer userId)
    {
        System.out.println(orderList);
        String ans=orderService.placeOrder(orderList,userId);
        System.out.println(ans);
        com.alibaba.fastjson.JSONObject model=new com.alibaba.fastjson.JSONObject();
        model.put("status",ans);
        return JSON.toJSONString(model, SerializerFeature.BrowserCompatible);
    }


    @GetMapping("/getOrderKey")
    public List<Integer> getOrderKey(@RequestParam(value="userId") Integer userId)
    {
        System.out.println("user");
        System.out.println(userId);

        List<Integer> ans=orderService.getOrderKey(userId);
        System.out.println(ans);
        return ans;
    }
    @GetMapping("/getOneOrder")
    public String getOneOrder(@RequestParam(value="itemId") Integer orderId)
    {
        System.out.println("user");
        System.out.println(orderId);

        List<OrderItem> order=orderService.getOneOrder(orderId);
       // System.out.println(ans);

        Iterator<OrderItem> it=order.iterator();
        ArrayList<JSONObject> orderJSON= new ArrayList<JSONObject>();
        while(it.hasNext())
        {
            OrderItem orderItem=it.next();

            JSONObject model=new JSONObject();
            model.put("key",orderItem.getOrderItemId());
            model.put("book",orderItem.getBook().getName());
            model.put("author",orderItem.getBook().getAuthor());
            model.put("isbn",orderItem.getBook().getIsbn());
            model.put("number",orderItem.getNumber());
            model.put("cover",orderItem.getBook().getExtraCover().getImage());
            model.put("price",orderItem.getBook().getPrice());
            orderJSON.add(model);
        }
        String  cartItemsString = JSON.toJSONString(orderJSON, SerializerFeature.BrowserCompatible);
        System.out.println(cartItemsString);
        return cartItemsString;
    }

    @GetMapping("/getAllOrders")
    public String getAllOrders()
    {
        System.out.println("get orders");
        //System.out.println(ans);
        List<Order> orders=orderService.getAllOrders();
        Iterator<Order> it=orders.iterator();
        ArrayList<JSONObject> orderJSON= new ArrayList<JSONObject>();
        while(it.hasNext())
        {
            Order order=it.next();

            JSONObject model=new JSONObject();
            model.put("key",order.getOrderId());
            model.put("user",order.getUser().getName());
            model.put("date",order.getDate().toString());
            model.put("userId",order.getUser().getUserId());

            orderJSON.add(model);
        }
        String  orderString = JSON.toJSONString(orderJSON, SerializerFeature.BrowserCompatible);
        System.out.println(orderString);
        return orderString;
    }

    @GetMapping("/getOrderTime")
    public Date getOrderTime(@RequestParam(value="orderId") Integer orderId)
    {
        Order order=orderService.getOrderById(orderId);
        return order.getDate();
    }
}
