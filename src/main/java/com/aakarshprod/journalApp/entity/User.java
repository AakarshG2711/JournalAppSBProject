package com.aakarshprod.journalApp.entity;



import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;


@Document(collection = "users")
@Data

public class User { //POJO CLASS(plain old java object)

    @Id
    private ObjectId id;

    @Indexed(unique = true)
    @NonNull
    private String userName;
    @NonNull
    private String password;

    private List<String> roles;

    @DBRef
    private List<JournalEntry> journalentries = new ArrayList<>();

    
   
}