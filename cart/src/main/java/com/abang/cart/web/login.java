package com.abang.cart.web;

import com.abang.cart.bean.User;
import com.abang.cart.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class login {
    @Autowired
    User user;
    @Autowired
    UserDao userDao;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("user");
        String passwd = request.getParameter("passwd");
        user.setName(name);
        user.setPasswd(passwd);
        System.out.println(user.toString());
        String passwdd = userDao.getUser(name);
        System.out.println(passwdd);


        return "login";

    }
}
