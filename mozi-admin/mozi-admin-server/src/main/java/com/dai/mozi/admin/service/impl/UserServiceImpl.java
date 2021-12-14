package com.dai.mozi.admin.service.impl;

import com.dai.mozi.admin.mapper.UserDAO;
import com.dai.mozi.admin.entity.User;
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

    @Override
    public String login(User user) {
        if (userDAO.selectByUserNameAndPsd(user) != null) {
//            System.out.println(userDAO.selectByUserNameAndPsd(user));
            return "登陆成功";
        } else {
            return "登陆失败";
        }
    }

    @Override
    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }
}
