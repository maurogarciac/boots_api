package com.example.boots_api;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Controller;

import com.example.boots_api.user.User;
import com.example.boots_api.visits.Visit;

@Controller
public class GeneralDaoService {

    protected static volatile GeneralDaoService instance;
    private static List<User> userDB = new ArrayList<>();
    private static List<Visit> visitDB = new ArrayList<>();
    
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

    public static List<User> getUserList(){
        System.out.println("The users list has been requested");
        return userDB;
    }
    public static List<Visit> getVisitsList(){
        System.out.println("The visits list as been requested");
        return visitDB;
    }

    public static User findOneById(Integer id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        User user = userDB.stream().filter(predicate).findFirst().orElse(null);
        System.out.println("A user has been requested " + user);
        return user;
    }
    public static User findOneByUsername(String username){
        Predicate<? super User> predicate = user -> user.getUsername().equals(username);
        return userDB.stream().filter(predicate).findFirst().orElse(null);
    }
}
