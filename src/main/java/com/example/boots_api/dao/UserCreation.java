package com.example.boots_api.dao;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.stereotype.Repository;

import com.example.boots_api.users.UserBean;

@Repository("fakeDB")
public class UserCreation implements UserBeanDao{
    
    private List<UserBean> DB = new ArrayList<>();

    public UserCreation(){
    }

    public List<UserBean> createUsers(){
        List<UserBean> users = new ArrayList<>();
        UserBean user;

        for(int i = 0; i >= 5; i++){
            user = new UserBean(usernameList[i], realNameList[i], randomDate());
            users.add(user);
        }
        this.DB.addAll(users);
        return users;
    }

    String[] usernameList = {"cooldog", "angrycat", "madangler", "spicybird", "naughtyferret", "goodrabbit"};
    String[] realNameList = {"Mauro Garcia", "Ignacio Elia", "Ricardo Ferrari", "Lucas Diaz", "Luciana Cappa", "Paula Gammarota"};
    
    private Date randomDate(){
        Date dob;
        Calendar cal = Calendar.getInstance();

        int year = randBetween(1900, 2010);
        int dayOfYear = randBetween(1, cal.getActualMaximum(Calendar.DAY_OF_YEAR));
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.DAY_OF_YEAR, dayOfYear);
        dob = cal.getTime();

        return dob;
    }

    public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }

    @Override
    public int insertUserBean(UserBean user) {
        DB.add(new UserBean(user.getUserName(), user.getRealName(), user.getDateOfBirth()));
        return 1;
    }

}
