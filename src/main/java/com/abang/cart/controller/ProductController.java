package com.abang.cart.controller;

import cn.hutool.json.JSONObject;
import com.abang.cart.bean.Product;
import com.abang.cart.service.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;

@Controller
public class ProductController {
    Logger logger = Logger.getLogger(ProductController.class);
    @Autowired
    ProductService productService;
    @RequestMapping(value = "/getProduct", method = RequestMethod.GET)
    public String getProduct(HttpServletRequest request) {

        String user = request.getParameter("name");
        List<Product> products = productService.getProdects();
        logger.info(products);
        JSONObject object = new JSONObject();
        object.put("products", products);
        object.put("name", user);
        request.setAttribute("data", object);
        logger.info(object);
        return "listProduct";
    }
    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public void addProduct(HttpServletRequest request) {


    }
}
