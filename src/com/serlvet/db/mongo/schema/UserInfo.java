package com.serlvet.db.mongo.schema;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.serlvet.controller.reqdata.ReqUser;
import com.serlvet.lib.GenerateId;

@Document(collection = "users")
@CompoundIndexes({ @CompoundIndex(def = "{'username' : 1, 'password': 1}") })
public class UserInfo implements Serializable {
    @Id
    private String id;

    @Indexed(unique = true)
    String userId;
    String username;
    String password;
    String name;
    String role;

    // 給Spring Security `UserDetails`使用的建構子
    public UserInfo() {
    }

    public UserInfo(ReqUser reqUser) {
        this.userId = GenerateId.forUserId();
        this.username = reqUser.getUsername();
        this.password = reqUser.getPassword();
        this.name = reqUser.getName();
        this.role = reqUser.getRole();
    }


    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
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
    public void setRole(String role) {
        this.role = role;
    }
    public String getRole() {
        return this.role;
    }
}
