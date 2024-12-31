package com.aakarshprod.journalApp.Repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.aakarshprod.journalApp.repository.UserRepositoryImpl;

@SpringBootTest
public class UserRepositoryImplTests {

    @Autowired
    private UserRepositoryImpl userRepo;

    @Test
    public void testSavedUser(){
        userRepo.getUsersForSA();
    }

}
