package com.serlvet.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.serlvet.db.mongo.collection.UserInfo;
import com.serlvet.db.mongo.repository.UserRepository;

@Controller
@RequestMapping("/register")
public class RegisterUser {
    MongoOperations mongoOps;
    @Autowired
    public RegisterUser(MongoOperations mongoOps) {
        this.mongoOps = mongoOps;
    }
//    UserRepository userRepository;
//    @Autowired
//    public RegisterUser(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
    //UserRepository userRepository;
    
    @RequestMapping(method = GET)
    public String home(Model model) {
        mongoOps.save(new UserInfo("stone1", "123456"));
        return "redirect:/login";
    }

}
