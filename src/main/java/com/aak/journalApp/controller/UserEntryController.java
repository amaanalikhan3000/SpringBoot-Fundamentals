package com.aak.journalApp.controller;


/* Special types of classes and components which handles
http request using post,put delete and get */


import com.aak.journalApp.Repository.UserRepo;
import com.aak.journalApp.entity.User;
import com.aak.journalApp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserEntryController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;
    @GetMapping("/all")
    public List<com.aak.journalApp.entity.User> GetAllUser() {
        return userService.getAll();
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
        userService.saveEntry((com.aak.journalApp.entity.User) user);
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User UserInDb = userService.findByUserName(userName);
        UserInDb.setUserName(user.getUserName());
        UserInDb.setPassword(user.getPassword());
        userService.saveEntry(UserInDb);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/user")
    public ResponseEntity<?>deleteByUserId(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userRepo.deleteByUserName(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
