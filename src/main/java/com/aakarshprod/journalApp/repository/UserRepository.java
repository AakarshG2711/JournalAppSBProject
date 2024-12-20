package com.aakarshprod.journalApp.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.aakarshprod.journalApp.entity.User;

public interface UserRepository extends MongoRepository< User , ObjectId > {

    User findByUserName(String userName);

    void deleteByuserName(String userName);
}
