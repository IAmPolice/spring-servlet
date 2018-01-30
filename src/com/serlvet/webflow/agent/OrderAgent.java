package com.serlvet.webflow.agent;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.serlvet.db.mongo.OrderTempl;
import com.serlvet.db.mongo.schema.Order;
import com.serlvet.db.mongo.schema.Purchaser;
import com.serlvet.db.mongo.schema.UserInfo;

@Component
public class OrderAgent {
    @Autowired
    private OrderTempl orderTempl;
    @Autowired
    private UserAgent userAgent;

    public List<Order> readAllOrder() {
        return orderTempl.getAllOrders();
    }

    public Order readOrder(String orderId) {
        return orderTempl.getOrder(orderId);
    }

    public String saveNewOrder(String title, MultipartFile menu, String description, String closeDate,
            String closeTime) {
        try {
            title = new String (title.getBytes("iso-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            orderTempl.saveNewOrder(userAgent.getUserInfo().getUserId(), title, menu.getBytes(), description,
                    sdf.parse(closeDate + " " + closeTime));
        } catch (ParseException | IOException e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    public String addPurchaser(String orderId, String item, int price) {
        UserInfo userInfo = userAgent.getUserInfo();
        orderTempl.modifyPurchaser(orderId, new Purchaser(userInfo.getUserId(), userInfo.getName(), item, price));
        return "success";
    }

    public String removePurchaser(String orderId, String item) {
        orderTempl.removePurchaser(userAgent.getUserInfo().getUserId(), orderId, item);
        return "success";
    }
}
