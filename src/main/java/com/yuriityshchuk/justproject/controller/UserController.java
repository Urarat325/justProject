package com.yuriityshchuk.justproject.controller;

import com.yuriityshchuk.justproject.model.Customer;
import com.yuriityshchuk.justproject.model.enumDB.Role;
import com.yuriityshchuk.justproject.repository.CustomerRepo;
import com.yuriityshchuk.justproject.repository.MessageRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class UserController {
    private final CustomerRepo customerRepo;
    private final MessageRepo messagesRepo;
    private final PasswordEncoder passwordEncoder;

    public UserController(CustomerRepo customerRepo, MessageRepo messagesRepo, PasswordEncoder passwordEncoder) {
        this.customerRepo = customerRepo;
        this.messagesRepo = messagesRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping(value = "/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String addUser(Model model, Customer customer) {

        Customer customerFromDB = customerRepo.findByUsername(customer.getUsername());
        if (customerFromDB != null) {
            model.addAttribute("messageErr", "Такой пользователь есть!!!");
            return "registration";
        }
        customer.setEmail("Нету");
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customer.setRoles(Collections.singleton(Role.USER));
        customerRepo.save(customer);
        return "registration";
    }
}
