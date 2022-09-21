package com.example.boots_api.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();
    private static Integer lastUserId = 0;
    
    static{
        users.add(new User(++lastUserId, "aulop", "Aurelio Lopez", LocalDate.now().minusYears(20)));
        users.add(new User(++lastUserId, "maling", "Mario Linguini", LocalDate.now().minusYears(25)));
        users.add(new User(++lastUserId, "Roboca", "Roberto Casanza", LocalDate.now().minusYears(30)));

    }
    //dont look into berkeley DBs
    public List<User> findAll(){
        return users;
    }
    public User findOnebyId(Integer id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().get();
    }
    public User findOnebyUsername(String username){
        Predicate<? super User> predicate = user -> user.getUsername().equals(username);
        return users.stream().filter(predicate).findFirst().get();
    }
    public User saveUser(User user){
        user.setId(++lastUserId);
        users.add(user);
        return user;
    }
}
