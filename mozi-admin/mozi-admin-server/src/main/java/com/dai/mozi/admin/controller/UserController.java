package com.dai.mozi.admin.controller;

import com.dai.mozi.admin.po.User;
import com.dai.mozi.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<User> getUserList() {
        return userService.getUserList();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") int id) {
        System.out.println(userService.getUserById(id).toString());
        return userService.getUserById(id);
    }

    @PostMapping("login")
    public String login(@RequestBody User user) {
        return userService.login(user);
    }
}
