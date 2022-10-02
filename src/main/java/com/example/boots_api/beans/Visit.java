package com.example.boots_api.beans;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Visit {
    
    private Integer visitId;
    private User user;
    private Date visitDate;

    public Visit(@JsonProperty("visit_id")Integer visitId,
                @JsonProperty("user")User user,
                @JsonProperty("visit_date")Date visitDate){
        super();
        this.visitId = visitId;
        this.user = user;
        this.visitDate = visitDate;
    }

    public Integer getId(){
        return visitId;
    }
    public void setId(Integer id){
        this.visitId = id;
    }
    public User getUser(){
        return user;
    }
    public void setUser(User user){
        this.user = user;
    }
    public Date getVisitDate(){
        return visitDate;
    }
    public void setVisitDate(Date visitDate){
        this.visitDate = visitDate;
    }
    @Override
    public String toString() {
        return "User [id=" + visitId + ", user that visited=" + user + ", date of visit=" + visitDate + "]";
    }
}
