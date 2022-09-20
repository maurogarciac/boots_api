package com.example.boots_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.boots_api.dao.UserBeanDao;
import com.example.boots_api.users.UserBean;

@Service
public class UserBeanService{

    private final UserBeanDao userBeanDao;

    @Autowired
    public UserBeanService(@Qualifier("fakeDB")UserBeanDao userBeanDao){
        this.userBeanDao = userBeanDao;
    }

    public int addUserBean(UserBean userBean){
        return userBeanDao.insertUserBean(userBean);
    }
}