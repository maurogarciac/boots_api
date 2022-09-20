package com.example.boots_api.users;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


public class UserBean {

    private String userName;
    private String realName;
    private Date dateOfBirth;
    

    public UserBean(@JsonProperty("userName")String user_name, 
                    @JsonProperty("realName")String real_name, 
                    @JsonProperty("dateOfBirth")String date_of_birth) {
        userName = user_name;
        realName = real_name;
        dateOfBirth = getDate(date_of_birth);
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
    private Date getDate(String date){
        Calendar cal = Calendar.getInstance();

        int[] dmy = Arrays.stream(date.split("-")).mapToInt(Integer::valueOf).toArray();

        cal.set(Calendar.YEAR, dmy[2]);
        cal.set(Calendar.MONTH, dmy[1]);
        cal.set(Calendar.DAY_OF_MONTH, dmy[0]);
        return cal.getTime();
    }
}
