package com.serlvet.db.mongo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.serlvet.db.mongo.schema.FuelConsumption;
import com.serlvet.db.mongo.schema.Order;
import com.serlvet.db.mongo.schema.Purchaser;

@Component
public class OrderTempl {
    @Autowired
    private MongoOperations mongoOps;

    public List<Order> getAllOrders() {
        return mongoOps.findAll(Order.class);
    }

    public Order getOrder(String orderId) {
        return (Order) mongoOps.findOne(new Query(Criteria.where("orderId").is(orderId)), Order.class);
    }

    public byte[] getOrderMenu(String orderId) {
        Order order = mongoOps.findOne(new Query(Criteria.where("orderId").is(orderId)), Order.class);
        return order.getMenu();
    }

    public void modifyPurchaser(String orderId, Purchaser purchaser) {
        Order order = getOrder(orderId); 
        Update update = new Update();
        for (int index = 0; index < order.getPurchaser().size(); index++) {
            Purchaser temp = order.getPurchaser().get(index);
            if ((temp.getUserId().equals(purchaser.getUserId())) && (temp.getItem().equals(purchaser.getItem()))) {
                order.getPurchaser().remove(index);
                break;
            }
        }
        order.getPurchaser().add(purchaser);
        update.set("purchaser", order.getPurchaser());
        mongoOps.updateFirst(new Query(Criteria.where("orderId").is(orderId)), update, Order.class);
    }

    public void removePurchaser(String userId, String orderId, String item) {
        Order order = getOrder(orderId); 
        Update update = new Update();
        for (int index = 0; index < order.getPurchaser().size(); index++) {
            Purchaser temp = order.getPurchaser().get(index);
            if ((temp.getUserId().equals(userId)) && (temp.getItem().equals(item))) {
                order.getPurchaser().remove(index);
                break;
            }
        }
        update.set("purchaser", order.getPurchaser());
        mongoOps.updateFirst(new Query(Criteria.where("orderId").is(orderId)), update, Order.class);
    }

    public void saveNewOrder(String userId, String title, byte[] menu, String description, Date closeTime) {
        mongoOps.save(new Order(userId, title, menu, description, closeTime));
    }
}
