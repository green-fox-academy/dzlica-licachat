package com.greenfox.dzlica.licachat.controllers;

import com.greenfox.dzlica.licachat.model.Log;
import com.greenfox.dzlica.licachat.model.User;
import com.greenfox.dzlica.licachat.model.UserHandler;
import com.greenfox.dzlica.licachat.repositories.model.LogRepo;
import com.greenfox.dzlica.licachat.repositories.model.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    LogRepo logRepo;

    @Autowired
    UserHandler userHandler;

    @GetMapping("/{id}/userlist")
    public String chat(Model model, HttpServletRequest request, @PathVariable Long id) {
        Log log = new Log("INFO", request);
        System.out.println(log.toString());
        logRepo.save(log);
        model.addAttribute("edituser", userRepo.findOne(id));
        return "userlist";
    }

    @PostMapping("/{id}/userlist")
    public String updateUSer(@ModelAttribute User user) {
        userRepo.save(user);
        return "redirect:/" + user.getId() + "/userlist";
    }

    @GetMapping("/enter")
    public String addUser(Model model) {
        model.addAttribute("adduser", new User());
        return "enter";
    }

    @PostMapping("/enter")
    public String addUserPost(@ModelAttribute User user, Model model) {
        if (user.name.equals("")) {
            model.addAttribute("listempty", "The userlist is empty!");
            return "redirect:/enter";
        }
        else if (userHandler.userExist(user.name)) {
            return "redirect:/enter";
        }
        else userRepo.save(user);
        model.addAttribute("user", userRepo.findAll());
        return "redirect:/" + user.getId() + "/userlist";
    }
}
