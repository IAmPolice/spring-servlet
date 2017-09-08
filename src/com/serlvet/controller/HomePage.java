package com.serlvet.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomePage {
    @Autowired
    MongoOperations mongoOps;

    @RequestMapping(method = GET)
    public String home(Model model) {
        System.out.println("home");
        return "home";
        //return "redirect:/login";
    }
}
