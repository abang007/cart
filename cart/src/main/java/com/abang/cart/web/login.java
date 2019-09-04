package com.abang.cart.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class login {
    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        String productName = request.getParameter("user");
        String passwd = request.getParameter("passwd");
        System.out.println(productName);
        return "login";
    }
}
