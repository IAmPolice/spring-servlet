package com.serlvet.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.serlvet.lib.MailAgent;

@Controller
@RequestMapping("/home")
public class HomePage {
    @Autowired
    MongoOperations mongoOps;

    @Autowired
    MailAgent mailAgent;

    @RequestMapping(method = GET)
    public String home(Model model) {
        // try {
        // mailAgent.sendMail();
        // } catch (MessagingException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        return "home";
        // return "redirect:/login";
    }
}
