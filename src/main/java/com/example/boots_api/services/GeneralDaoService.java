package com.example.boots_api.services;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Predicate;

import org.springframework.stereotype.Controller;

import com.example.boots_api.beans.User;
import com.example.boots_api.beans.Visit;

@Controller
public class GeneralDaoService {

    protected static volatile GeneralDaoService instance;
    private static ConcurrentLinkedQueue<User> userDB = new ConcurrentLinkedQueue<>();
    private static ConcurrentLinkedQueue<Visit> visitDB = new ConcurrentLinkedQueue<>();
    
    private GeneralDaoService(){}

    public static GeneralDaoService getInstance(){
        if(instance == null){
            synchronized(GeneralDaoService.class){
                if(instance == null){
                    instance = new GeneralDaoService();
                }
            }
        }
        return instance;
    }

    public static ConcurrentLinkedQueue<User> getUserList(){
        System.out.println("The users list has been requested");
        return userDB;
    }
    public static ConcurrentLinkedQueue<Visit> getVisitsList(){
        System.out.println("The visits list as been requested");
        return visitDB;
    }

    public static User findOneById(Integer id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        System.out.println("user has been requested");
        return userDB.stream().filter(predicate).findFirst().orElse(null);
    }
    public static User findOneByUsername(String username){
        Predicate<? super User> predicate = user -> user.getUsername().equals(username);
        return userDB.stream().filter(predicate).findFirst().orElse(null);
    }
    public static Date dateRightNow(){
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2022);
        cal.set(Calendar.MONTH, 10);
        cal.set(Calendar.DATE, 2);
        date = cal.getTime();
        return date;
    }
}
