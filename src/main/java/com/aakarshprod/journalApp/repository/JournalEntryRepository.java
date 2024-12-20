package com.aakarshprod.journalApp.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.aakarshprod.journalApp.entity.JournalEntry;



public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId>{
    

 
}


