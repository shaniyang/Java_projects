package com.example.viikko91;

public class MovieTheatre extends MovieTheatreList {

    private String City;
    private String theatreId;


    public MovieTheatre(){

    }


    public String getCity(){

        return City;
    }

    public void setCity(String l){

        City = l;

    }

    public void setTheatreId(String i){

        theatreId = i;

    }

    public String getTheatreId(){

        return theatreId;
    }

}
