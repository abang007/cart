package com.abang.cart.controller;

import cn.hutool.json.JSONObject;
import com.abang.cart.bean.ProductItem;
import com.abang.cart.service.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class OrderItemController {
    private Logger logger = Logger.getLogger(OrderItemController.class);
    @Autowired
    ProductService productService;
    @Autowired
    ProductItem productItem;

    @RequestMapping(value = "/addOrderItem", method = RequestMethod.POST)
    public String addOrderItem(HttpServletRequest request) {
        JSONObject object = new JSONObject();
        int pid = Integer.parseInt(request.getParameter("pid"));
        int num = Integer.parseInt(request.getParameter("num"));
        logger.info("pid:" + pid + ">>>>num:" + num);
        productItem.setProduct(productService.getProdect(pid));
        productItem.setNum(num);
        logger.info("productItem:" + productItem);
        object.put("data", productItem);
        logger.info("object:"+object);
        request.setAttribute("pro",object);
        return "listCar";
    }
}
