package com.abang.cart.controller;

import com.abang.cart.bean.User;
import com.abang.cart.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    User user;
    @Autowired
    UserDao userDao;

    @RequestMapping("insertUser")
    public String insertUser() {
        return null;
    }
}
