package com.example.bookback.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.bookback.entity.Book;
import com.example.bookback.entity.OrderItem;
import com.example.bookback.service.OrderItemService;
import com.example.bookback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class OderItemController {
    @Autowired
    private OrderItemService orderItemService;


    @RequestMapping("/addToCart")
    public Integer addToCart(@RequestParam(value="userId") Integer userId , @RequestParam(value = "bookId",required = false) Integer bookId, @RequestParam(value = "itemId",required = false) Integer itemId){
        System.out.println("add to cart");
        System.out.println(userId);
        System.out.println(bookId);
        System.out.println(itemId);

        if(itemId==null)
        {
            OrderItem orderItem=orderItemService.getByUserAndBook(userId,bookId);
            if(orderItem==null)
            {
                orderItemService.addOrderItem1(userId,bookId);
                return 1;
            }
            else {
                orderItemService.addOrderItem2(userId,bookId,orderItem.getOrderItemId());
                return orderItem.getNumber();
            }
        }
        else
        {
            System.out.println("By Button");
            return orderItemService.addOrderItemByItemId(itemId);
        }





    }

    @GetMapping("/getCartItems")
    public String getCartItems(@RequestParam(value="userId") Integer userId )
    {
        System.out.println("getCartItems");
        System.out.println(userId);
        List<OrderItem> ans=orderItemService.getCartItems(userId);
        Iterator<OrderItem> it =ans.iterator();

        ArrayList<JSONObject> cartItemsJson = new ArrayList<JSONObject>();
        while (it.hasNext()) {
            OrderItem orderItem = (OrderItem) it.next();

            JSONObject model=new JSONObject();
            model.put("key",orderItem.getOrderItemId());
            model.put("book",orderItem.getBook().getName());
            model.put("author",orderItem.getBook().getAuthor());
            model.put("isbn",orderItem.getBook().getIsbn());
            model.put("number",orderItem.getNumber());
            model.put("cover",orderItem.getBook().getExtraCover().getImage());
            model.put("price",orderItem.getBook().getPrice());
            model.put("description",orderItem.getBook().getDescription());
            model.put("stock",orderItem.getBook().getInventory());
            model.put("selected",false);
            cartItemsJson.add(model);
        }

        String  cartItemsString = JSON.toJSONString(cartItemsJson, SerializerFeature.BrowserCompatible);
        System.out.println(cartItemsString);
        return cartItemsString;
    }

    @RequestMapping("/removeCartItem")
    public Integer removeCartItem(@RequestParam(value="userId") Integer userId , @RequestParam(value = "itemId",required = false) Integer itemId)
    {
        System.out.println("remove from cart");
        System.out.println(userId);
        System.out.println(itemId);

        return orderItemService.removeCartItem(itemId);

    }
}
