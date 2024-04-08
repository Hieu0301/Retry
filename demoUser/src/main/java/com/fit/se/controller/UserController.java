package com.fit.se.controller;


import com.fit.se.entity.User;
import com.fit.se.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getListUser(){
        return  userService.getListUser();
    }

    @GetMapping("/users/{id}")
    public User getDepartmentById(@PathVariable(value = "id") int id){
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable(value = "userId") int userId){
        userService.deleteUserById(userId);
    }



}
