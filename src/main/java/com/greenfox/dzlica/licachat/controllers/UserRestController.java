package com.greenfox.dzlica.licachat.controllers;

import com.greenfox.dzlica.licachat.LicachatApplication;
import com.greenfox.dzlica.licachat.model.*;
import com.greenfox.dzlica.licachat.repositories.model.ChatMessageRepo;
import com.sun.xml.internal.ws.api.message.Packet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Timestamp;

@RestController
public class UserRestController {

//    @Autowired
//    private MessageStatus messageStatus;

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
        if (recive.getClient() == null && recive.getChatMessage() == null) {
            return new Hiba("Something wrong");

        }
        return new Response("ok" + HttpStatus.OK);
    }
}
