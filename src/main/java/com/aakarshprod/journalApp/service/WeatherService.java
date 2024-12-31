package com.aakarshprod.journalApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.aakarshprod.journalApp.Cache.AppCache;
import com.aakarshprod.journalApp.api.response.WeatherResponse;

@Component
public class WeatherService {


     @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppCache appCache;

    @Value("${weather.api.key}")
    private String apikey ;

    private static final String API = "http://api.weatherstack.com/current?access_key=APIKEY&query=CITY";

    public WeatherResponse getWeather(String City){
        String finalAPI = appCache.App_Cache.get("weather_api").replace("<city>", City).replace("<apikey>", apikey);
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.GET, null, WeatherResponse.class );
        return response.getBody();
    }

}
