package com.aakarshprod.journalApp.api.response;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class WeatherResponse{
    
    
    private Current current;

    @Getter
    @Setter
    public class Current{
        public String observation_time;
        public int temperature;
        public int weather_code;
        public int humidity;
        public int cloudcover;
        public int feelslike;
        public int uv_index;
        public int visibility;
        public String is_day;
    }
    
    
    
    
    
}
  
