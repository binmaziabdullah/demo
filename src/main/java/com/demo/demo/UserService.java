package com.demo.demo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class UserService {


    private static ArrayList<User> users = new ArrayList<>();

    /* here we are using @PostConstruct Annotation to perform initialization when the dependency
     injection is done, so we have the loadUser() method and have the logic inside that method ,
     to add the users using ArrayList method all() , so this logic will be executed when the
      dependency injection is done*/
    @PostConstruct
    private void loadUser() {

        users.addAll(Arrays.asList(new User(1L, "A", 55), new User(2L, "B", 58)));
    }


    public static List<User> getAllUsers() {

        return users;
    }

    public static void addUsers(User user) {
        users.add(user);

    }

    public static void updateUser(User user, Long id) {
        int counter = 0;
        for (User user1 : users) {
            if (user1.getId().equals(id)) {
                users.set(counter, user);
            }
            counter++;
        }
    }

    public static void deleteUser(Long id) {
        users.removeIf(user -> user.getId().equals(id));
    }


}
