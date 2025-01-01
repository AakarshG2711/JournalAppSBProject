package com.aakarshprod.journalApp.Services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.aakarshprod.journalApp.service.EmailService;

@SpringBootTest
public class EmailServiceTests {

    @Autowired
    private EmailService emailService;

    @Test
    public void testSendMail(){
        emailService.sendEmail(
        "21bei001@ietdavv.edu.in", 
        "testing project mail", 
        "What is ggoing on in college?");
    }

}
