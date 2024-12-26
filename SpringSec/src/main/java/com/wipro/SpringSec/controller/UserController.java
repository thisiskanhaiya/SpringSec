package com.wipro.SpringSec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.SpringSec.model.User;
import com.wipro.SpringSec.service.UserService;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("register")
    public User addUser(@RequestBody User user) {
        user = userService.addUser(user);
        return user;
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return userService.verify(user);
    }
}
