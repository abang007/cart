package com.abang.cart.web;

import com.abang.cart.bean.User;
import com.abang.cart.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class Register {

    @Autowired
    User user;
    @Autowired
    UserDao userDao;
    @RequestMapping(value = "/register",method = POST)
    public String register(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String passwd = request.getParameter("passwd");
//        String surePasswd = request.getParameter("surePasswd");
        System.out.println("name:" + name);
        System.out.println("passwd:"+passwd);
        if ((name == null || ("").equals(name) || ((passwd == null) || ("").equals(passwd)))) {
            System.out.println("请填写完整的注册信息！");
            response.sendRedirect("register.html");
            return null;
        } else {
            String dataPasswd = userDao.getUser(name);
            //若用户不存在，则进行注册
            if (null == dataPasswd) {
                user.setName(name);
                user.setPasswd(passwd);
                System.out.println(user.toString());
                userDao.insertUser(user);
                System.out.println("注册成功！");
            } else {//若用户存在则表示用户已被注册
                System.out.println("该用户已被注册");
                return null;
            }
        }
        return "secceed";
    }

}
