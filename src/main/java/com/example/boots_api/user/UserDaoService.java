package com.example.boots_api.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();
    private static Integer userCount = 0;

    private static List<Visit> visits = new ArrayList<>();
    private static Integer visitCount = 0;
    
    static{
        users.add(new User(++userCount, "aulop", "Aurelio Lopez", LocalDate.now().minusYears(20)));
        users.add(new User(++userCount, "maling", "Mario Linguini", LocalDate.now().minusYears(25)));
        users.add(new User(++userCount, "Roboca", "Roberto Casanza", LocalDate.now().minusYears(30)));
        visits.add(new Visit(++visitCount, users.get(visitCount), LocalDate.now().minusDays(1)));
        visits.add(new Visit(++visitCount, users.get(visitCount), LocalDate.now().minusDays(2)));
        visits.add(new Visit(++visitCount, users.get(visitCount), LocalDate.now().minusDays(5)));
        visits.add(new Visit(++visitCount, users.get(0), LocalDate.now().minusDays(12)));
        visits.add(new Visit(++visitCount, users.get(1), LocalDate.now().minusDays(17)));
    }

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
        user.setId(++userCount);
        users.add(user);
        return user;
    }
    
    public List<Visit> findAllVisits(){
        return visits;
    }
    public List<Visit> findVisitsByUser(User user){
        Predicate<? super Visit> predicate = visit -> visit.getUser().equals(user);
        return visits.stream().filter(predicate).toList();
    }
    public Visit saveVisit(User user){
        Visit visit = new Visit(++visitCount, user, LocalDate.now());
        visits.add(visit);
        return visit;
    }
    public Visit saveVisitByUsername(String username){
        Visit visit = new Visit(++visitCount, findOnebyUsername(username), LocalDate.now());
        visits.add(visit);
        return visit;
    }
}
