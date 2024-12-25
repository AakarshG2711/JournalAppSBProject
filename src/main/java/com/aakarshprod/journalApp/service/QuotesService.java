package com.aakarshprod.journalApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class QuotesService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String apikey = "e1c8412471c06c25624c374b7c3398a7" ;

    private static final String API = "http://api.weatherstack.com/current?access_key=APIKEY&query=CITY";


}

