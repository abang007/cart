package com.abang.cart.controller;

import com.abang.cart.dao.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {

    @Autowired
    CategoryDao categoryDao;
    @RequestMapping("/getCount")
    public String getCount() {
        System.out.println(categoryDao.count());
        return "show";
    }
}
