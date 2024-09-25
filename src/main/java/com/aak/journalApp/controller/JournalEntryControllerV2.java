package com.aak.journalApp.controller;


/* Special types of classes and components which handles
http request using post,put delete and get */

import com.aak.journalApp.entity.JournalEntry;
import com.aak.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

    @Autowired
    JournalEntryService journalEntryService;


    // method
    @GetMapping("/abc")
    public List<JournalEntry> getAll(){
        return journalEntryService.getAll();

    }

    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry myEntry){
        myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);

        return myEntry;
    }


    @GetMapping("id/{id}")
    public JournalEntry getEntryById(@PathVariable ObjectId id){
        return journalEntryService.findById(id).orElse(null);

    }

    @DeleteMapping("id/{myid}")
    public boolean deleteEntry(@PathVariable ObjectId myid){
          journalEntryService.deleteById(myid);
          return true;
    }

    @PutMapping("id/{id}")
    public JournalEntry updateById(@PathVariable ObjectId id,@RequestBody JournalEntry myEntry){

        JournalEntry old = journalEntryService.findById(id).orElse(null);

        if(old!=null) {
            old.setTitle(myEntry.getTitle()!=null && !myEntry.getTitle().equals("")? myEntry.getTitle(): old.getTitle());
            old.setContent(myEntry.getContent()!=null && !myEntry.getContent().equals("")? myEntry.getContent(): old.getContent());
        }
        journalEntryService.saveEntry(old);
        return old;
    }



}
