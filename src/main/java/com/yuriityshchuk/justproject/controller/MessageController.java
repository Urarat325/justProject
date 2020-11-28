package com.yuriityshchuk.justproject.controller;

import com.yuriityshchuk.justproject.model.Customer;
import com.yuriityshchuk.justproject.model.DBFile;
import com.yuriityshchuk.justproject.model.Subject;
import com.yuriityshchuk.justproject.repository.CustomerRepo;
import com.yuriityshchuk.justproject.repository.MessageRepo;
import com.yuriityshchuk.justproject.service.DBFileService;
import com.yuriityshchuk.justproject.service.MessageService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class MessageController {

    private final MessageRepo messageRepo;
    private final MessageService messageService;
    private final CustomerRepo customerRepo;
    private final DBFileService dbFileService;


    public MessageController(MessageRepo messageRepo, MessageService messageService, CustomerRepo customerRepo, DBFileService dbFileService) {
        this.messageRepo = messageRepo;
        this.messageService = messageService;
        this.customerRepo = customerRepo;
        this.dbFileService = dbFileService;
    }

    @GetMapping(value = "/generalList")
    public String generalList(Model model) {
        model.addAttribute("messages", messageRepo.findAll());
        return "generalList";
    }

    @PostMapping(value = "/generalList/addMessage")
    public String addMessage(@RequestParam String course,
                             @RequestParam String semester,
                             @RequestParam String message,
                             @RequestParam List<MultipartFile> files,
                             Subject subject,
                             Authentication authentication) {

        Customer customer = customerRepo.findByUsername(authentication.getName());
        List<DBFile> dbFile = dbFileService.convertForDB(files);

        String s = messageService.addMessage(course, semester, subject, message, customer, dbFile);
        return "redirect:/generalList?" + s;
    }

}
