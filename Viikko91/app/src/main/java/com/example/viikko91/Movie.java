package com.example.viikko91;

public class Movie extends MovieTheatre {

    private String id;
    private String startDate;
    private String endDate;
    private String EventId;
    private String Title;
    private String TheatreID;

    public Movie() {
    }

    public String getStartDate(){

        return startDate;
    }

    public void setStartDate(String sd){

        startDate = sd;

    }

    public String getEndDate(){

        return endDate;
    }

    public void setEndDate(String ed){

        endDate = ed;

    }

    public String getTitle(){

        return Title;
    }

    public void setTitle(String t){

        Title = t;

    }

    public String getTheatreID(){

        return TheatreID;
    }

    public void setTheatreID(String tid){

        TheatreID = tid;

    }

    public String getEventId(){

        return EventId;
    }

    public void setEventId(String eid){

        EventId = eid;

    }

    public String getTheatreId(){

        return id;
    }

    public void setTheatreId(String i){

        id = i;
    }
}
