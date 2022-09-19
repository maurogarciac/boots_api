package com.example.boots_api.users;

import java.util.Date;


public class UserBean {

    //private User user;
    private String userName;
    private String realName;
    private Date dateOfBirth;
    

    public UserBean(String user_name, String real_name, Date date_of_birth) {
        userName = user_name;
        realName = real_name;
        dateOfBirth = date_of_birth;  
    }
    public void setUserName(String uN){
        userName = uN;   
    }
    public String getUserName(){
        return userName;
    }
    public void setRealName(String rN){
        realName = rN;
    }
    public String getRealName(){
        return realName;
    }
    public void setDateOfBirth(Date date){
        dateOfBirth = date;
    } 
    public Date getDateOfBirth(){
        return dateOfBirth;
    }
}
