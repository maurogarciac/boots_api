package com.example.boots_api.beans;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    
    private Integer id;
    private String userName;
    private String name;
    private Date birthDate;

    public User(@JsonProperty("id")Integer id, 
                @JsonProperty("user_name")String userName, 
                @JsonProperty("name")String name, 
                @JsonFormat(pattern="yyyy-MM-dd")
                @JsonProperty("birth_date")Date birthDate){
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
    public Date getBirthDate(){
        return birthDate;
    }
    public void setBirthDate(Date birthDate){
        this.birthDate = birthDate;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + userName + ", name=" + name + ", birth date=" + birthDate + "]";
    }
}
