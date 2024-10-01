package com.aak.journalApp.controller;


import com.aak.journalApp.entity.User;
import com.aak.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/public")
@RestController
public class PublicController {
    @Autowired
    UserService userService;

    @GetMapping("/health-check")
    public String healthCheck(){
        return "ok";
    }

    @PostMapping("/create-user")
    public void createUser(@RequestBody User user){
        userService.saveEntry(user);
    }
}
