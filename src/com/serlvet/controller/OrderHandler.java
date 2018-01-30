package com.serlvet.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.serlvet.db.mongo.OrderTempl;

@Controller
@RequestMapping("/order")
public class OrderHandler {
    @Autowired
    private OrderTempl orderTempl;

    @RequestMapping(value = "/menu/{orderId}", method = GET)
    public @ResponseBody byte[] orderMenu(@PathVariable String orderId) {
        return orderTempl.getOrderMenu(orderId);
    }

    @RequestMapping(value = "/test/{orderId}", method = GET)
    public @ResponseBody String orderMenu1(@PathVariable String orderId) {
        String a;
        try {
            a = new String (orderId.getBytes("iso-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "111";
    }
}
