package com.serlvet.db.mongo.schema;

import java.io.Serializable;
import java.util.Date;

public class Purchaser implements Serializable {

    String userId;
    String name;
    String item;
    int price;
    Date time;

    public Purchaser(String userId, String name, String item, int price) {
        this.userId = userId;
        this.name = name;
        this.item = item;
        this.price = price;
        this.time = new Date();
    }

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public Date getTime() {
        return time;
    }
    public void setTime(Date time) {
        this.time = time;
    }
}
