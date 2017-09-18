package com.serlvet.webflow.agent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.serlvet.db.mongo.collection.UserInfo;
import com.serlvet.db.mongo.repository.UserRepository;

@Component
public class UserAgent {
    @Autowired
    UserRepository userRepository;

    public UserInfo getUserInfo(String username) {
        return userRepository.findByUsername(username);
    }
}
