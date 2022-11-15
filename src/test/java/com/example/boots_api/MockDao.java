package com.example.boots_api;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Predicate;

import org.springframework.stereotype.Controller;

import com.example.boots_api.beans.User;
import com.example.boots_api.beans.Visit;

@Controller
public class MockDao {

    protected static volatile MockDao instance;
    private static ConcurrentLinkedQueue<User> userDB = new ConcurrentLinkedQueue<>();
    private static ConcurrentLinkedQueue<Visit> visitDB = new ConcurrentLinkedQueue<>();
    private static Integer lastUserId = -1;
    private static Integer lastVisitId = -1;



    private MockDao(){}

    public static MockDao getInstance(){
        if(instance == null){
            synchronized(MockDao.class){
                if(instance == null){
                    instance = new MockDao();
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
        System.out.println("The visitDB list as been requested");
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
    // ------------------------------------------------users--------
    public List<User> findAll(){
        return new ArrayList<>(userDB);
    }
    public User saveUser(User user){
        user.setId(++lastUserId);
        userDB.add(user);
        return user;
    }
    public void deleteById(Integer id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        userDB.removeIf(predicate);
    }
    public void deleteByUsername(String username){
        Predicate<? super User> predicate = user -> user.getUsername().equals(username);
        userDB.removeIf(predicate);
    }
    //------------------------------------------------visits----------
    public ConcurrentLinkedQueue<Visit> findAllVisits(){
        return visitDB;
    }
    public List<Visit> findVisitsByUsername(String username){
        Predicate<? super Visit> predicate = visit -> visit.getUser().equals(findOneByUsername(username));
        return visitDB.stream().filter(predicate).toList();
    }
    public List<Visit> findVisitsByUserId(Integer userId){
        Predicate<? super Visit> predicate = visit -> visit.getUser().equals(findOneById(userId));
        return visitDB.stream().filter(predicate).toList();
    }
    public Visit saveVisit(User user){
        Visit visit = new Visit(++lastVisitId, user, LocalDate.now());
        visitDB.add(visit);
        return visit;
    }
    public Visit saveVisitByUsername(String username){
        Visit visit = new Visit(++lastVisitId, findOneByUsername(username), LocalDate.now());
        visitDB.add(visit);
        return visit;
    }
    public Visit saveVisitByUsernameId(Integer userId){
        Visit visit = new Visit(++lastVisitId, findOneById(userId), LocalDate.now());
        visitDB.add(visit);
        return visit;
    }
    public List<Visit> findVisitsByUser(User user){
        Predicate<? super Visit> predicate = visit -> visit.getUser().equals(user);
        return visitDB.stream().filter(predicate).toList();
    } 
}
