package com.example.boots_api.visits;

import java.time.LocalDate;

import com.example.boots_api.user.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Visit {
    
    private Integer visitId;
    private User user;
    private LocalDate visitDate;

    public Visit(@JsonProperty("visit_id")Integer visitId,
                @JsonProperty("user")User user,
                @JsonProperty("visit_date")LocalDate visitDate){
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
    public LocalDate getVisitDate(){
        return visitDate;
    }
    public void setVisitDate(LocalDate visitDate){
        this.visitDate = visitDate;
    }
    @Override
    public String toString() {
        return "User [id=" + visitId + ", user that visited=" + user + ", date of visit=" + visitDate + "]";
    }
}
