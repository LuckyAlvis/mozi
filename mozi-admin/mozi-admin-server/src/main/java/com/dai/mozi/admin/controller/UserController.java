package com.dai.mozi.admin.controller;

import com.dai.mozi.admin.po.User;
import com.dai.mozi.admin.po.pojo.Data;
import com.dai.mozi.admin.po.pojo.JsonRootBean;
import com.dai.mozi.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    RestTemplate restTemplate;

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

    @GetMapping("/list1/{bvid}")
    public Boolean getBilibili(@PathVariable("bvid") String bvid) {
        try {
            JsonRootBean jsonRootBean = restTemplate.getForObject("https://api.bilibili.com/x/player/pagelist?bvid=" + bvid + "&jsonp=jsonp", JsonRootBean.class);
            assert jsonRootBean != null;
            for (Data data : jsonRootBean.getData()) {
                System.out.println(data.getPart() + "\t" + String.format("%.1f", (double) data.getDuration() / 60));
            }
        } catch (Exception e) {
            return false;
        }
        return true;

    }
}
