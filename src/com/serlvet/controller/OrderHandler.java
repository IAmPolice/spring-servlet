package com.serlvet.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serlvet.db.mongo.collection.UserInfo;
import com.serlvet.db.mongo.repository.UserRepository;

@RestController
@RequestMapping("/test")
public class OrderHandler {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(method = GET)
    public UserInfo home() {
        return userRepository.findByUsername("stone1");
//    public List<UserInfo> home() {
//        List<UserInfo> a = Arrays.asList(userRepository.findByUsername("stone5"));
//        return a;
        //return "{ a:1}";
        //return userRepository.findByUsername("stone1");
        //return "redirect:/login";
    }
}
