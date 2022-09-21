package com.example.boots_api.user;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
    @GetMapping("/users/id/{id}")
    public User retrieveUserById(@PathVariable int id){
        return service.findOnebyId(id);
    }
    @GetMapping("/users/username/{username}")
    public User retrieveUserByUsername(@PathVariable String username){
        return service.findOnebyUsername(username);
    }
    @PostMapping("/users")
    public void createUser(@RequestBody User user){
        service.saveUser(user);
    }
    //falta un put tambien por ahi - para poder updatear los datos del usario
    //y un delete para eliminar los usuarios
    //el PUT recibe un ID y el POST crea un usuario



}
