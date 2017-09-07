package com.serlvet.db.mongo.collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class UserInfo {
    @Id
    private String id;

    String username;
    String password;

    public UserInfo(String username, String password) {
        this.username = username;
        this.password = password;
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
}
