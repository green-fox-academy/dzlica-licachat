package com.greenfox.dzlica.licachat.controllers;

import com.greenfox.dzlica.licachat.repositories.model.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    UserRepo userRepo;

    @RequestMapping("/")
    public String chat(Model model) {
        model.addAttribute("user", userRepo.findAll());
        return "user";
    }
}
