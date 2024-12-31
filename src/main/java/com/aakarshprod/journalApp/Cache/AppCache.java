package com.aakarshprod.journalApp.Cache;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aakarshprod.journalApp.entity.ConfigJournalAppEntity;
import com.aakarshprod.journalApp.repository.ConfigJournalAppRepository;

import jakarta.annotation.PostConstruct;

@Component
public class AppCache {

    public enum keys {
        weather_api;
    }

    @Autowired
    private ConfigJournalAppRepository configJournalAppRepository;

    public HashMap<String , String> App_Cache;

    @PostConstruct
    public void init(){
        App_Cache = new HashMap<>();
        List<ConfigJournalAppEntity> all = configJournalAppRepository.findAll(); 
        for(ConfigJournalAppEntity configJournalAppEntity : all ){
            App_Cache.put(configJournalAppEntity.getKey(), configJournalAppEntity.getValue());
        }
        App_Cache = null;
    }
}
