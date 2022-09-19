package com.example.boots_api.users;

import java.util.Calendar;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @RequestMapping(method = RequestMethod.GET, path = "/get-Users")
    public String helloWorld(){
        return "Hello World";
    }
    @RequestMapping(method = RequestMethod.GET, path = "/user-test")
    public UserBean requestUser(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1988);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1); 
        Date dob = cal.getTime();
        return new UserBean("maugc", "Mauro Garcia Coto", dob);
    }
    @RequestMapping(value="/user-list", method=RequestMethod.GET)
    public UserCreation requestAllUsers() {
        return new UserCreation();
    }
}
