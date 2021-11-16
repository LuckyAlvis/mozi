package com.dai.mozi.admin.service.impl;

import com.dai.mozi.admin.mapper.UserDAO;
import com.dai.mozi.admin.po.User;
import com.dai.mozi.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> getUserList() {
        return userDAO.getUserList();
    }
}
