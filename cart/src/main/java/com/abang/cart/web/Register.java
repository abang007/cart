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

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class Register {
    @Autowired
    User user;
    @Autowired
    UserDao userDao;
    //接受用户注册请求
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public void register(@RequestBody JSONObject json,HttpServletResponse response) throws IOException {
        System.out.println("接受前台传来的json:"+json.toString());
        String name = (String) json.get("name");
        String passwd = (String) json.get("passwd");
        System.out.println("name:" + name+","+"passwd:"+passwd);
        JSONObject object = new JSONObject();  //创建Json对象
        response.setCharacterEncoding("UTF-8");
        //用户名及密码如果为空
        if (name == null || passwd == null || ("").equals(name) || ("").equals(passwd)) {

            object.put("msg", "用户名或密码不能为空！！！");   //设置Json对象的属性
            System.out.println(object.toString());
            response.getWriter().write(String.valueOf(object));
            //用户名及密码如果不为空
        } else {
            String dataPasswd = userDao.getUserName(name);
            System.out.println("dataUser："+dataPasswd);
            //查不到该用户
            if (dataPasswd == null) {
                user.setName(name);
                user.setPasswd(passwd);
                userDao.insertUser(user);
                object.put("msg", "注册成功！！！");
                System.out.println("注册成功");
                response.getWriter().write(String.valueOf(object));
            } else {
                object.put("msg", "注册的用户已存在！！！");
                response.getWriter().write(String.valueOf(object));
            }
        }
    }


}
