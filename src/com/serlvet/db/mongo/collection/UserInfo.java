package com.serlvet.db.mongo.collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.serlvet.controller.reqdata.ReqUser;

@Document(collection = "users")
public class UserInfo {
    @Id
    private String id;

    String username;
    String password;
    String name;

//    public UserInfo(String username, String password) {
//        this.username = username;
//        this.password = password;
//    }
    public UserInfo(ReqUser reqUser) {
        this.username = reqUser.getUsername();
        this.password = reqUser.getPassword();
        this.name = reqUser.getName();
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return this.username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return this.password;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}
