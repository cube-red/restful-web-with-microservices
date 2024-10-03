package com.aditya.rest.webservices.user;


import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private static List<User> list = new ArrayList<>();
    private static int usersCount = 0;
    static {
        list.add(new User(1,"asd", LocalDate.now().minusYears(25)));
        list.add(new User(3,"ity", LocalDate.now().minusYears(25)));
        list.add(new User(5,"qee", LocalDate.now().minusYears(25)));
        list.add(new User(2,"tye", LocalDate.now().minusYears(25)));
    }

    public List<User> getAllUsers(){
        return list;
    }

    public User getUser(Integer id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return list.stream().filter(predicate).findFirst().get();
    }

    public User save(User user) {
        user.setId(++usersCount);
        list.add(user);
        return user;
    }

}
