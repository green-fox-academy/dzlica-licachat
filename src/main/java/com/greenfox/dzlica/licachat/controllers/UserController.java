package com.greenfox.dzlica.licachat.controllers;

import com.greenfox.dzlica.licachat.model.Log;
import com.greenfox.dzlica.licachat.model.User;
import com.greenfox.dzlica.licachat.repositories.model.LogRepo;
import com.greenfox.dzlica.licachat.repositories.model.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    LogRepo logRepo;

    @RequestMapping({"/", "userlist"})
    public String chat(Model model, HttpServletRequest request) {
        Log log = new Log("INFO", request);
        logRepo.save(log);
        model.addAttribute("log", logRepo.findAll());
        System.out.println(log.toString());
        return "userlist";

        //The log should look like this: 2017-05-16 21:47:19.040 INFO Request /message POST text=apple
    }

    @GetMapping("/enter")
    public String addUser(Model model) {
        model.addAttribute("adduser", new User());

        return "enter";
    }

    @PostMapping("/enter")
    public String addUserPost(@ModelAttribute User user, Model model) {
        userRepo.save(user);
        model.addAttribute("user", userRepo.findAll());
        return "userlist";
    }
}
