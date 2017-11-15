package com.serlvet.lib;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailAgent {
    @Autowired
    private JavaMailSender mailSender;

    public void sendMail() throws MessagingException {
        System.out.println("go");
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        // helper.setFrom("style80964@gmail.com");
        // helper.setFrom("stone_shih@gemteks.com");
        helper.setFrom("nancy_dai@acesolution.com.tw");

        // helper.setTo("a_921246@hotmail.com");
        helper.setTo("style80964@gmail.com");
        helper.setSubject("New spittle from ");
        helper.setText("!23");
        helper.addBcc("nancy_dai@acesolution.com.tw");
        mailSender.send(message);
    }
}
