package com.aakarshprod.journalApp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.aakarshprod.journalApp.api.response.QuotesResponse;

@Component
public class QuotesService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String API = "https://stoic.tekloon.net/stoic-quote";

    public QuotesResponse getQuotes(){
        ResponseEntity<QuotesResponse> Quote = restTemplate.exchange(API, HttpMethod.GET, null, QuotesResponse.class);
        return Quote.getBody();
    }

}

