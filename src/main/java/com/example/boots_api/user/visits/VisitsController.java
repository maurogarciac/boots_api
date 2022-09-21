package com.example.boots_api.user.visits;

import com.example.boots_api.user.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class VisitsController {

    private VisitsDaoService visitsService;

    public VisitsController(VisitsDaoService visitsService){
        this.visitsService = visitsService;
    }

    @GetMapping("/visits/all")
    public List<Visit> retrieveAllVisits(){
        return visitsService.findAllVisits();
    }
    @GetMapping("/visits")
    public List<Visit> retrieveVisitByUserID(@RequestParam("user_id") int userId){
        return visitsService.findVisitsByUser(findOnebyId(userId));
    }
    @GetMapping("/visits/username/{username}")
    public List<Visit> retrieveVisitByUsername(@PathVariable String username){
        return visitsService.findVisitsByUser(findOnebyUsername(username));
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
