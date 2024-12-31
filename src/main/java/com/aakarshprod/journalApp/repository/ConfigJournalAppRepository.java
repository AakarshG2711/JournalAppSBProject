package com.aakarshprod.journalApp.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.aakarshprod.journalApp.entity.ConfigJournalAppEntity;




public interface ConfigJournalAppRepository extends MongoRepository<ConfigJournalAppEntity, ObjectId>{
    

 
}



