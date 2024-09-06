package com.shashwat.userservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/")
    public String welcome() {
        return "Welcome to JobScheduler Application";
    }
}
