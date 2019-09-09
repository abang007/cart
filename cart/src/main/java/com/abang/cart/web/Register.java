package com.abang.cart.web;

import cn.hutool.json.JSONObject;
import com.abang.cart.bean.User;
import com.abang.cart.dao.UserDao;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
    public void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String passwd = request.getParameter("passwd");
        System.out.println("name:" + name);
        System.out.println("passwd:"+passwd);
        JSONObject jsonObject = new JSONObject();

        if ((name == null || ("").equals(name) || ((passwd == null) || ("").equals(passwd)))) {
            System.out.println("请填写完整的注册信息！");
            String str = "请填写完整的注册信息！";
            jsonObject.put("msg",str);
            String obj = jsonObject.toString();
            response.getWriter().write(obj);
            System.out.println(obj);

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
                String msg = "该用户已被注册";
                jsonObject.put("msg",msg);
                response.getWriter().write(jsonObject.toString());
                return;
            }
        }
        String msg = "注册成功";
        jsonObject.put("msg",msg);
        response.getWriter().write(jsonObject.toString());
        return;
    }

}
