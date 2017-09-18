package com.serlvet.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mongodb.DuplicateKeyException;

@ControllerAdvice
@RequestMapping("/error")
public class WebExceptionHandler {

    @RequestMapping(method = GET)
    public String getPage(Model model) {
        return "error";
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public String duplicateKeyHandler() {
        return "redirect:/error";
    }
}
