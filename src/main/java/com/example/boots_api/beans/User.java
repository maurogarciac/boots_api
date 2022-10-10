package com.example.boots_api.beans;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    
    private Integer id;
    @JsonProperty("user_name") private String userName;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd") @JsonProperty("birth_date") private Date birthDate;

    public User(@JsonProperty("id")Integer id, 
                @JsonProperty("user_name")String userName, 
                @JsonProperty("name")String name, 
                @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
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
    @JsonProperty("user_name")
    public String getUsername(){
        return userName;
    }
    @JsonProperty("user_name")
    public void setUsername(String userName){
        this.userName = userName;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    @JsonProperty("birth_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    public Date getBirthDate(){
        return birthDate;
    }
    @JsonProperty("birth_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    public void setBirthDate(Date birthDate){
        this.birthDate = birthDate;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", user_name=" + userName + ", name=" + name + ", birth date=" + birthDate + "]";
    }
}
