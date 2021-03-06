package com.dai.mozi.admin.service;

import com.dai.mozi.admin.po.User;

import java.util.List;


public interface UserService {
    List<User> getUserList();

    String login(User user);

    User getUserById(int id);
}
