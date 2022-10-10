package com.example.boots_api.services;
 
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.example.boots_api.beans.User;

//dont look into berkeley DBs

@Component
public class UserDaoService {

    private static ConcurrentLinkedQueue<User> users = GeneralDaoService.getUserList();
    private static Integer lastUserId = -1;
    private static Date dateNow = GeneralDaoService.dateRightNow(false);
    
    static{
        users.add(new User(++lastUserId, "aulop", "Aurelio Lopez", dateNow));
        users.add(new User(++lastUserId, "maling", "Mario Linguini", dateNow));
        users.add(new User(++lastUserId, "Roboca", "Roberto Casanza", dateNow));
    }
    
    public List<User> findAll(){
        return new ArrayList<>(users);
    }
    public User saveUser(User user){
        user.setId(++lastUserId);
        users.add(user);
        return user;
    }
    public void deleteById(Integer id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }
    public void deleteByUsername(String username){
        Predicate<? super User> predicate = user -> user.getUsername().equals(username);
        users.removeIf(predicate);
    }
}
