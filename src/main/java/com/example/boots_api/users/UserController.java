package com.example.boots_api.users;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.boots_api.dao.UserCreation;
import com.example.boots_api.service.UserBeanService;

@RestController
public class UserController {

    private final UserBeanService userBeanService;

    @Autowired
    public UserController(UserBeanService userBeanService){
        this.userBeanService = userBeanService;
    }
    @PostMapping(path = "/post-user")
    public void addUserBean(UserBean userBean){
        userBeanService.addUserBean(userBean);
    }
    @RequestMapping(method = RequestMethod.GET, path = "/user-test")
    public UserBean getUser(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1988);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1); 
        Date dob = cal.getTime();
        return new UserBean("maugc", "Mauro Garcia Coto", dob);
    }
    @RequestMapping(value="/user-list", method=RequestMethod.GET)
    public List<UserBean> getAllUsers() {
        UserCreation uC = new UserCreation();
        return uC.createUsers();
    }
}
