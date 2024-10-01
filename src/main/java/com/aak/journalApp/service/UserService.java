package com.aak.journalApp.service;


import com.aak.journalApp.Repository.UserRepo;
import com.aak.journalApp.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class UserService {

    @Autowired
    private UserRepo userRepo;


    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public void saveEntry (User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList());
        userRepo.save(user);
    }

    public void saveNewUser (User user){

        userRepo.save(user);
    }

    public List<User> getAll(){
        return userRepo.findAll();
    }

    public Optional<User> findById(ObjectId id){
        return userRepo.findById(id);
    }

    public void deleteById(ObjectId id){
        userRepo.deleteById(id);
    }
    public User findByUserName(String userName){
        return userRepo.findByUserName(userName);
    }
}
