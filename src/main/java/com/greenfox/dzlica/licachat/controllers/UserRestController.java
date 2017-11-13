package com.greenfox.dzlica.licachat.controllers;

import com.greenfox.dzlica.licachat.model.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserRestController {


    @GetMapping("/")
    public void chatApp(HttpServletRequest request) {
        Log log = new Log("INFO", request);
        System.err.println(log.toString());
    }

}
