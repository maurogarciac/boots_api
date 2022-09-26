package com.example.boots_api.services;

import com.example.boots_api.beans.User;
import com.example.boots_api.beans.Visit;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class VisitsDaoService {
    
    private static ConcurrentLinkedQueue<Visit> visits = GeneralDaoService.getVisitsList();
    private static Integer lastVisitId = 0;

    static{
        visits.add(new Visit(++lastVisitId, GeneralDaoService.findOneById(0), LocalDate.now()));
        visits.add(new Visit(++lastVisitId, GeneralDaoService.findOneById(0), LocalDate.now()));
        visits.add(new Visit(++lastVisitId, GeneralDaoService.findOneById(0), LocalDate.now()));
    }
    public ConcurrentLinkedQueue<Visit> findAllVisits(){
        return visits;
    }
    public List<Visit> findVisitsByUsername(String username){
        Predicate<? super Visit> predicate = visit -> visit.getUser().equals(GeneralDaoService.findOneByUsername(username));
        return visits.stream().filter(predicate).toList();
    }
    public List<Visit> findVisitsByUserId(Integer userId){
        Predicate<? super Visit> predicate = visit -> visit.getUser().equals(GeneralDaoService.findOneById(userId));
        return visits.stream().filter(predicate).toList();
    }
    public Visit saveVisit(User user){
        Visit visit = new Visit(++lastVisitId, user, LocalDate.now());
        visits.add(visit);
        return visit;
    }
    public Visit saveVisitByUsername(String username){
        Visit visit = new Visit(++lastVisitId, GeneralDaoService.findOneByUsername(username), LocalDate.now());
        visits.add(visit);
        return visit;
    }
    public Visit saveVisitByUsernameId(Integer userId){
        Visit visit = new Visit(++lastVisitId, GeneralDaoService.findOneById(userId), LocalDate.now());
        visits.add(visit);
        return visit;
    }
    public List<Visit> findVisitsByUser(User user){
        Predicate<? super Visit> predicate = visit -> visit.getUser().equals(user);
        return visits.stream().filter(predicate).toList();
    } 
}
