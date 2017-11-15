package com.serlvet.webflow.agent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import com.serlvet.db.mongo.repository.UserRepository;
import com.serlvet.db.mongo.schema.UserInfo;

@Component
public class UserAgent {
    @Autowired
    UserRepository userRepository;

    public UserInfo seachUserInfo(String username) {
        // List<UserInfo> a = userRepository.findByRole("role_admin");
        // for(UserInfo model : a) {
        // System.out.println(model.getUsername());
        // }
        return userRepository.findByUsername(username);
    }

    public UserInfo getUserInfo() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findByUsername(user.getUsername());
    }
}
