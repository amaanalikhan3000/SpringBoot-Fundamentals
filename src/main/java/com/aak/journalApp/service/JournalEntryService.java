package com.aak.journalApp.service;

import com.aak.journalApp.Repository.JournalEntryRepo;
import com.aak.journalApp.entity.JournalEntry;
import com.aak.journalApp.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepo journalEntryRepo;

    @Autowired
    private UserService userService;

    @Transactional
    public void saveEntry (JournalEntry journalEntry, String userName){
        try {
            /*This line is retrieving a User object from the userService by using the findByUserName method.
              The userName parameter is used to search for the user in the database (presumably through a
              repository method like findByUserName).
             */
            User user = userService.findByUserName(userName);
            // Setting Time
            journalEntry.setDate(LocalDateTime.now());

            JournalEntry saved = journalEntryRepo.save(journalEntry);

            user.getJournalEntries().add(saved);
            user.setUserName(null);
            userService.saveEntry(user);
        }
        catch (Exception e){
            log.error("Exception",e);
            throw new RuntimeException("An error occurred while saving the entry",e);
        }

    }

    public void saveEntry (JournalEntry journalEntry){
        try {
            journalEntryRepo.save(journalEntry);
        }
        catch (Exception e){
            log.error("Exception",e);
        }

    }


    public List<JournalEntry> getAll(){
        return journalEntryRepo.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id){
        return journalEntryRepo.findById(id);
    }

    public void deleteById(ObjectId id, String userName){
        User user = userService.findByUserName(userName);
        user.getJournalEntries().removeIf(x->x.getId().equals(id));
        userService.saveEntry(user);
        journalEntryRepo.deleteById(id);
    }
}
