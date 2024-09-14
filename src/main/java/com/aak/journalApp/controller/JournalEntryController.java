package com.aak.journalApp.controller;


/* Special types of classes and components which handles
http request using post,put delete and get */

import com.aak.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    // table type long is id
    private Map<Long,JournalEntry> journalEntries = new HashMap<>();

    // method
    @GetMapping("/abc")
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        journalEntries.put(myEntry.getId(),myEntry);
        return true;
    }


    @GetMapping("id/{id}")
    public JournalEntry getEntryById(@PathVariable Long id){
        return journalEntries.get(id);
    }

    @DeleteMapping("id/{id}")
    public JournalEntry deleteEntry(@PathVariable Long id){
        return journalEntries.remove(id);
    }

    @PutMapping("id/{id}")
    public JournalEntry updateById(@PathVariable Long id,@RequestBody JournalEntry myEntry){
        return journalEntries.put(id,myEntry);
    }



}
