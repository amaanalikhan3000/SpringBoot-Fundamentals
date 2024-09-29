package com.aak.journalApp.controller;


/* Special types of classes and components which handles
http request using post,put delete and get */


import com.aak.journalApp.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserEntryController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<com.aak.journalApp.entity.User> GetAllUser(){
        return userService.getAll();
    }

    @PostMapping
    public void createUser(@RequestBody User user){
        userService.saveEntry((com.aak.journalApp.entity.User) user);
    }

    @PutMapping("/{userName}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable String userName){
        com.aak.journalApp.entity.User UserInDb = userService.findByUserName(userName);
        if(UserInDb!=null){
            UserInDb.setUserName(user.getUsername());
            UserInDb.setPassword(user.getPassword());
            userService.saveEntry(UserInDb);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
