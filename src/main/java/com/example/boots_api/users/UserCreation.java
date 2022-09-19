package com.example.boots_api.users;

import java.util.Date;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class UserCreation {
    
    List<UserBean> allUsers;
    UserBean instUser;

    public UserCreation(){
        allUsers = createUsers();
        for (UserBean user : allUsers){
            instUser = user;
        }
    }
    public List<UserBean> createUsers(){
        List<UserBean> users = new ArrayList<UserBean>();

        for(int i = 0; i > 4; i++){
            UserBean user = new UserBean(usernameList[i], realNameList[i], dateOfBirthList.get(i));
            users.add(user);
        }
        return users;
    }

    String[] usernameList = {"cooldog", "madcat", "angryangler", "spicybird", "naughtyferret", "goodrabbit"};
    String[] realNameList = {"Mauro Garcia", "Ignacio Elia", "Ricardo Ferrari", "Lucas Diaz", "Luciana Cappa", "Paula Gammarota"};
    int[][] rawBirthdates = {{1998, 2, 16}, {1985, 10, 2}, {1977, 11, 20}, {1992, 4, 11}, {1989, 7, 18}, {1982, 6, 29}};
    List<Date> dateOfBirthList = makeDate(rawBirthdates);
    
    private List<Date> makeDate(int[][] rawBirthdates){

        List<Date> dob = new LinkedList<Date>();

        for (int[] arrays : rawBirthdates) {
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, arrays[0]);
            cal.set(Calendar.MONTH, arrays[1]);
            cal.set(Calendar.DAY_OF_MONTH, arrays[2]);
            dob.add(cal.getTime());
        }
        return dob;
    }
}
