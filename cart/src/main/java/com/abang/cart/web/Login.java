package com.abang.cart.web;

import cn.hutool.json.JSONObject;
import com.abang.cart.bean.User;
import com.abang.cart.dao.UserDao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
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
    public void login(@RequestBody JSONObject data,
                      HttpServletResponse response) throws IOException, ServletException {
        final Logger logger = Logger.getLogger(Login.class);
        logger.info("传入的数据:"+data);
        String name = (String) data.get("user");
        String passwd = (String) data.get("passwd");
        user.setName(name);
        user.setPasswd(passwd);

        JSONObject object = new JSONObject();
        response.setCharacterEncoding("utf-8");
        //判断是否是用户注册
        //判断用户登陆
        logger.info("判断用户是否存在："+name);
        if (name == null || name.equals("")) {
            object.put("msg", "用户不存在，请点击注册！");
            response.getWriter().write(object.toString());
            System.out.println("用户不存在，请点击注册！");
            return;
        }
        logger.info("数据库查询:start");
        String dataPasswd = userDao.getUser(name);
        logger.info("数据库查询:end");
        if (dataPasswd == null || !dataPasswd.equals(passwd)) {
            object.put("msg", "用户或者密码输入错误");
            response.getWriter().write(object.toString());
            System.out.println("用户或者密码输入错误");
        } else if (dataPasswd.equals(passwd)) {
            object.put("msg", "登陆成功！");
            response.getWriter().write(object.toString());
            logger.info("登陆成功:"+object.get("msg"));
        }

    }

}
