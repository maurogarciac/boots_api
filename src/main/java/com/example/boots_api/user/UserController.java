package com.example.boots_api.user;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    private UserDaoService service;
    
    public UserController(UserDaoService service){
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }
    @GetMapping("/users/{id}")
    public User retrieveUserById(@PathVariable int id){
        return service.findOnebyId(id);
    }
    @GetMapping("/users/{username}")
    public User retrieveUserByUsername(@PathVariable String username){
        return service.findOnebyUsername(username);
    }
    @PostMapping("/users")
    public void createUser(@RequestBody User user){
        service.saveUser(user);
    }
    
    @GetMapping("/visits/all")
    public List<Visit> retrieveAllVisits(){
        return service.findAllVisits();
    }
    @GetMapping("/visits/user_id={id}")
    public List<Visit> retrieveVisitByID(@PathVariable int id){
        return service.findVisitsByUser(service.findOnebyId(id));
    }
    @GetMapping("/visits/username={username}")
    public List<Visit> retrieveVisitByUsername(@PathVariable String username){
        return service.findVisitsByUser(service.findOnebyUsername(username));
    }
    @PostMapping("/visits")
    public void createVisit(@RequestBody User user){
        service.saveVisit(user);
    }
    @PostMapping("/visits")
    public void createVisitByUsername(@RequestBody String username){
        service.saveVisitByUsername(username);
    }


}
