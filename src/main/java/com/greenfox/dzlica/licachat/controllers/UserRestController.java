package com.greenfox.dzlica.licachat.controllers;

import com.greenfox.dzlica.licachat.LicachatApplication;
import com.greenfox.dzlica.licachat.model.*;
import com.greenfox.dzlica.licachat.repositories.model.ChatMessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserRestController {


    @Autowired
    ChatMessageRepo chatMessageRepo;



    @GetMapping("/")
    public void chatApp(HttpServletRequest request) {
        Log log = new Log("INFO", request);
        System.err.println(log.toString());
    }

    @CrossOrigin("*")
    @PostMapping("/api/message/receive")
    public Object receive(@RequestBody Recive recive) {
        if (recive.getClient() == null && recive.getMessage() == null) {
            return new Hiba("Something wrong");

        }
        chatMessageRepo.save(recive.getMessage());
        return new Response("ok" + HttpStatus.OK);
    }

    @GetMapping("api/messages")
    public Object listMessage() {
        return chatMessageRepo.findAll();
    }


}
