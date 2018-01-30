package com.serlvet.db.mongo.schema;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import com.serlvet.lib.GenerateId;

@Document(collection = "orders")
@CompoundIndexes({ @CompoundIndex(def = "{'username' : 1}") })
public class Order implements Serializable {
    @Id
    private String id;

    String orderId;
    String sponsor;
    Date createTime;
    String title;
    byte[] menu;
    String description;
    Date closeTime;
    List<Purchaser> purchaser;

    public Order(String sponsor, String title, byte[] menu, String description, Date closeTime) {
        this.sponsor = sponsor;
        this.orderId = GenerateId.forOrderId();
        this.createTime = new Date();
        this.title = title;
        this.menu = menu;
        this.description = description;
        this.closeTime = closeTime;
        this.purchaser = new ArrayList();
    }

    public String getSponsor() {
        return sponsor;
    }
    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }
    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public byte[] getMenu() {
        return menu;
    }
    public void setMenu(byte[] menu) {
        this.menu = menu;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getCloseTime() {
        return closeTime;
    }
    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }
    public List<Purchaser> getPurchaser() {
        return purchaser;
    }
    public void setPurchaser(List<Purchaser> purchaser) {
        this.purchaser = purchaser;
    }
}
