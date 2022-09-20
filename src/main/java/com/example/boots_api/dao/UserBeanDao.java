package com.example.boots_api.dao;

import com.example.boots_api.users.UserBean;


public interface UserBeanDao{

    int insertUserBean(UserBean userBean);


    default int addUserBean(UserBean userBean){
        return insertUserBean(userBean);
    }
    
}
