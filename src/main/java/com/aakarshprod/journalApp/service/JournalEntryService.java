package com.aakarshprod.journalApp.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.aakarshprod.journalApp.entity.JournalEntry;
import com.aakarshprod.journalApp.entity.User;
import com.aakarshprod.journalApp.repository.JournalEntryRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j //lombok element for looger 
@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(JournalEntryService.class);

    @Transactional
    public void saveEntry(JournalEntry journalEntry, String userName){
        try {
        journalEntry.setDate(LocalDateTime.now());
        User user = userService.findByUserName(userName);
        JournalEntry saved = journalEntryRepository.save(journalEntry);
        user.getJournalentries().add(saved);
        userService.saveUser(user);
        } catch (Exception e) {
            log.error("Error Occured", e);;
            throw new RuntimeException("An error occured while saving the entry" , e);
        }
    }

    public void saveEntry(JournalEntry journalEntry){
        journalEntry.setDate(LocalDateTime.now());
        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getAll(){
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findByid(ObjectId Id) {
        return journalEntryRepository.findById(Id);
    }

    @Transactional
    public void deleteByID(ObjectId Id , String userName){
        try {
            User user = userService.findByUserName(userName);
        Boolean removed = user.getJournalentries().removeIf(x -> x.getId().equals(Id));
        if(removed){
            userService.saveUser(user);
            journalEntryRepository.deleteById(Id);
        }
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("An error occured while deleting the entry" , e);
        }
    }

    // public List<JournalEntry> findByUserName(String username){

    // }
}
