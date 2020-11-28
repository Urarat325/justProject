package com.yuriityshchuk.justproject.controller;

import com.yuriityshchuk.justproject.repository.CustomerRepo;
import com.yuriityshchuk.justproject.repository.MessageRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final CustomerRepo customerRepo;
    private final MessageRepo messagesRepo;

    public UserController(CustomerRepo customerRepo, MessageRepo messagesRepo) {
        this.customerRepo = customerRepo;
        this.messagesRepo = messagesRepo;
    }

    @GetMapping(value = "/registration")
    public String registration(Model model) {
        return "registration";
    }

//    @PostMapping(value = "/registration")
//    public String registration(){
//
//    }
}
