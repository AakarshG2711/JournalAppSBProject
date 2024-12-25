package com.aakarshprod.journalApp.api.response;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuotesResponse{
    private Data data;

    @Getter
    @Setter
    public class Data{
        public String author;
        public String quote;
    }

}







