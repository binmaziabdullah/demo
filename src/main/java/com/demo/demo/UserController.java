package com.demo.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public List<User> getAllStudent() {

        return UserService.getAllUsers();
    }

    @PostMapping
    public String addStudent(@RequestBody User user) {
        UserService.addUsers(user);
        return "Student Save Successfully";
    }

    @PutMapping("/{id}")
    public static String updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        UserService.updateUser(user, id);

        return "Record updated successfully";
    }

    @DeleteMapping("/{id}")
    public static String deleteUser(@PathVariable Long id) {
        UserService.deleteUser(id);

        return "Record deleted";
    }


}
