package com.greenfox.dzlica.licachat.controllers;

import com.greenfox.dzlica.licachat.model.Log;
import com.greenfox.dzlica.licachat.repositories.model.LogRepo;
import com.greenfox.dzlica.licachat.repositories.model.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    LogRepo logRepo;

    @RequestMapping("/")
    public String chat(Model model, HttpServletRequest request) {
        model.addAttribute("user", userRepo.findAll());
        Log log = new Log("INFO", request);
//        if (System.getenv("CHAT_APP_LOGLEVEL").equals("ERROR")) {
//            System.out.println("There is an error");
//        }
        return log.toString();

        //The log should look like this: 2017-05-16 21:47:19.040 INFO Request /message POST text=apple
    }
}
