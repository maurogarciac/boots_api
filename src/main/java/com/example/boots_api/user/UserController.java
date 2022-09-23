package com.example.boots_api.user;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.boots_api.GeneralDaoService;

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
        User user = GeneralDaoService.findOneById(id);
        if(user==null)throw new UserNotFoundException("id:" + id);
        return user;
    }
    @GetMapping("/users/username/{username}")
    public User retrieveUserByUsername(@PathVariable String username){
        User user = GeneralDaoService.findOneByUsername(username);
        if(user==null)throw new UserNotFoundException("username:" + username);
        return user;
    }
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User createdUser = service.saveUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/id/{id}").buildAndExpand(createdUser.getId()).toUri(); 
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/users/id/{id}")
    public ResponseEntity<User> modifyUser(@PathVariable int id, @RequestBody String username, @RequestBody String name, @RequestBody LocalDate birthDate){
        User user = GeneralDaoService.findOneById(id);
        if(name != null){
            user.setName(name);
        }
        if(username != null){
            user.setUsername(username);
        }
        if(birthDate != null){
            user.setBirthDate(birthDate);
        }
        return ResponseEntity.ok(user);
    }
    @DeleteMapping("/users/id/{id}")
    public void deleteById(@PathVariable int id){
        service.deleteById(id);
    }
    @DeleteMapping("/users/username/{username}")
    public void deleteByUsername(@PathVariable String username){
        service.deleteByUsername(username);
    }

}
