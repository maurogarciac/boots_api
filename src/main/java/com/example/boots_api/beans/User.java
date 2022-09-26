package com.example.boots_api.beans;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    
    private Integer id;
    private String userName;
    private String name;
    private LocalDate birthDate;

    public User(@JsonProperty("id")Integer id, 
                @JsonProperty("user_name")String userName, 
                @JsonProperty("name")String name, 
                @JsonProperty("birth_date")LocalDate birthDate){
        super();
        this.id = id;
        this.userName = userName;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }
    public String getUsername(){
        return userName;
    }
    public void setUsername(String userName){
        this.userName = userName;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public LocalDate getBirthDate(){
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate){
        this.birthDate = birthDate;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + userName + ", name=" + name + ", birth date=" + birthDate + "]";
    }
}
