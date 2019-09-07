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
import java.io.IOException;

@Controller
public class Login {
    @Autowired
    User user;
    @Autowired
    UserDao userDao;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("user");
        String passwd = request.getParameter("passwd");
        user.setName(name);
        user.setPasswd(passwd);
        System.out.println(name);
        System.out.println(user.toString());
        String dataPasswd = userDao.getUser(name);

        //判断是否是用户注册
        String register =  request.getParameter("register");
        System.out.println("register:"+register);
        if ("注册账号".equals(register)) {
            response.sendRedirect("register.html");
            return null;
        }

        //判断用户登陆
        if (name == null || name.equals("")) {
            System.out.println("用户不存在，请点击注册！");
            response.sendRedirect("index.html");
        } else if (dataPasswd==null) {
            System.out.println("用户或者密码输入错误");
        } else if (dataPasswd.equals(passwd)){
            System.out.println("登陆成功！");
            return "login";
        }
        return "show";

    }
}
