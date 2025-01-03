package com.aakarshprod.journalApp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aakarshprod.journalApp.api.response.QuotesResponse;
import com.aakarshprod.journalApp.api.response.WeatherResponse;
import com.aakarshprod.journalApp.entity.User;
import com.aakarshprod.journalApp.repository.UserRepository;
import com.aakarshprod.journalApp.service.QuotesService;
import com.aakarshprod.journalApp.service.UserService;
import com.aakarshprod.journalApp.service.WeatherService;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WeatherService weatherService;

    @Autowired 
    private QuotesService quotesService;

    @PutMapping()
    public ResponseEntity<?> updateUser(@RequestBody User user){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User userInDB = userService.findByUserName(userName);
        if(userInDB != null){
            userInDB.setUserName(user.getUserName());
            userInDB.setPassword(user.getPassword());
            userService.saveNewUser(userInDB);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUserById(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userRepository.deleteByuserName(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<?> greetings(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        WeatherResponse weatherResponse = weatherService.getWeather("Mumbai");
        QuotesResponse quotesResponse = quotesService.getQuotes();
        String greetings = " " ;
        String quotes = " " ;
        if(weatherResponse != null){
            greetings = "Weather feels like " + weatherResponse.getCurrent().getFeelslike();
        }
        if(quotesResponse != null){
            quotes = " Quote of the day is " + quotesResponse.getData().getQuote();
        }
        return new ResponseEntity<>("Hi " + authentication.getName() + greetings + quotes , HttpStatus.OK);
    }
}     
