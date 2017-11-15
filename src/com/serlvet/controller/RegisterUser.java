package com.serlvet.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.serlvet.controller.reqdata.ReqUser;
import com.serlvet.db.mongo.schema.UserInfo;

@Controller
@RequestMapping("/register")
public class RegisterUser {
    @Autowired
    MongoOperations mongoOps;
    // UserRepository userRepository;
    // @Autowired
    // public RegisterUser(UserRepository userRepository) {
    // this.userRepository = userRepository;
    // }
    // UserRepository userRepository;

    @RequestMapping(method = GET)
    public String getPage(Model model) {
        return "register";
    }

    @RequestMapping(method = POST)
    public String registerUser(ReqUser reqUser, Model model) {
        mongoOps.save(new UserInfo(reqUser));
        return "redirect:/login";
    }

}
