package com.example.boots_api.user.visits;

import com.example.boots_api.user.User;
import com.example.boots_api.user.UserDaoService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class VisitsDaoService {

    private static List<Visit> visits = new ArrayList<>();
    private static Integer lastVisitId = 0;

    private UserDaoService service;

    public VisitsDaoService(UserDaoService service){
        this.service = service;
    }


    public List<Visit> findAllVisits(){
        return visits;
    }
    public List<Visit> findVisitsByUser(User user){
        Predicate<? super Visit> predicate = visit -> visit.getUser().equals(user);
        return visits.stream().filter(predicate).toList();
    }
    public Visit saveVisit(User user){
        Visit visit = new Visit(++lastVisitId, user, LocalDate.now());
        visits.add(visit);
        return visit;
    }
    public Visit saveVisitByUsername(String username){
        Visit visit = new Visit(++lastVisitId, findOnebyUsername(username), LocalDate.now());
        visits.add(visit);
        return visit;
    }
}
