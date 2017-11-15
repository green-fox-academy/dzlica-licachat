package com.greenfox.dzlica.licachat.controllers;

import com.greenfox.dzlica.licachat.model.ChatMessage;
import com.greenfox.dzlica.licachat.model.Log;
import com.greenfox.dzlica.licachat.model.User;
import com.greenfox.dzlica.licachat.model.UserHandler;
import com.greenfox.dzlica.licachat.repositories.model.ChatMessageRepo;
import com.greenfox.dzlica.licachat.repositories.model.LogRepo;
import com.greenfox.dzlica.licachat.repositories.model.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

@Controller
public class UserController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    LogRepo logRepo;

    @Autowired
    UserHandler userHandler;

    @Autowired
    ChatMessageRepo chatMessageRepo;

    @GetMapping("/{id}/userlist")
    public String chat(Model model, User user, @PathVariable Long id, @RequestParam(required = false) String text) {
        model.addAttribute("edituser", userRepo.findOne(id));
        model.addAttribute("addmessage", new ChatMessage());
        model.addAttribute("messages", chatMessageRepo.findAll());
        return "userlist";
    }

    @PostMapping("/{id}/userlist")
    public String updateUSer(@ModelAttribute User user) {
        userRepo.save(user);
        return "redirect:/" + user.getId() + "/userlist";
    }

    @PostMapping("/{id}/addpost")
    public String postMessage(@PathVariable Long id, @ModelAttribute ChatMessage chatMessage) {
        User user = userRepo.findOne(id);
        chatMessage.setUsername(user.getName());
        chatMessage.setTimestamp(new Timestamp(System.currentTimeMillis()));
        chatMessage.setId(chatMessage.randomId());
        chatMessageRepo.save(chatMessage);
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
