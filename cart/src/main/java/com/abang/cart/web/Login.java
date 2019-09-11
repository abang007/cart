package com.abang.cart.web;

import cn.hutool.json.JSONObject;
import com.abang.cart.bean.User;
import com.abang.cart.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(@RequestBody JSONObject data, HttpServletResponse response) throws IOException {
        System.out.println(data);
        String name = (String) data.get("user");
        String passwd = (String) data.get("passwd");
        user.setName(name);
        user.setPasswd(passwd);
        System.out.println(user.toString());
        JSONObject object = new JSONObject();
        response.setCharacterEncoding("utf-8");
        //判断是否是用户注册
        //判断用户登陆
        System.out.println("name:" + name);
        if (name == null || name.equals("")) {
            object.put("msg", "用户不存在，请点击注册！");
            response.getWriter().write(object.toString());
            System.out.println("用户不存在，请点击注册！");
            return;
        }
        String dataPasswd = userDao.getUser(name);
        System.out.println("dataPasswd:"+dataPasswd);
        if (dataPasswd == null || !dataPasswd.equals(passwd)) {
            object.put("msg", "用户或者密码输入错误");
            response.getWriter().write(object.toString());
            System.out.println("用户或者密码输入错误");
        } else if (dataPasswd.equals(passwd)) {
            object.put("msg", "登陆成功！");
            response.getWriter().write(object.toString());
            System.out.println("登陆成功！");
        }

    }
}
