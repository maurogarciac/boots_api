package com.example.boots_api.controllers;

import com.example.boots_api.beans.User;
import com.example.boots_api.beans.Visit;
import com.example.boots_api.services.VisitsDaoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;


@RestController
public class VisitsController {

    private VisitsDaoService visitsService;

    public VisitsController(VisitsDaoService visitsService){
        this.visitsService = visitsService;
    }

    @GetMapping("/visits/all")
    public ConcurrentLinkedQueue<Visit> retrieveAllVisits(){
        return visitsService.findAllVisits();
    }
    @GetMapping("/visits")
    public List<Visit> retrieveVisitByUserID(@RequestParam("user_id") int userId){
        return visitsService.findVisitsByUserId(userId);
    }
    @GetMapping("/visits/username/{username}")
    public List<Visit> retrieveVisitByUsername(@PathVariable String username){
        return visitsService.findVisitsByUsername(username);
    }
    @PostMapping("/visits")
    public void createVisit(@RequestBody User user){
        visitsService.saveVisit(user);
    }
    @PostMapping("/visits/username/{username}")
    public void createVisitByUsername(@PathVariable String username){
        visitsService.saveVisitByUsername(username);
    }
}
