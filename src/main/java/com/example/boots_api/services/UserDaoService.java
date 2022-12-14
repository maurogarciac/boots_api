package com.example.boots_api.services;
 
import java.util.ArrayList;
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
    
    /*
    
    static{
    users.add(new User(++lastUserId, "aulop", "Aurelio Lopez", LocalDate.now().minusYears(25));
    users.add(new User(++lastUserId, "maling", "Mario Linguini", LocalDate.now().minusYears(20)));
    users.add(new User(++lastUserId, "Roboca", "Roberto Casanza", LocalDate.now().minusYears(25)));
    }
    */
    
    
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
