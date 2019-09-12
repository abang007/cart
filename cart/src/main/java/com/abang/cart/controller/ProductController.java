package com.abang.cart.controller;

import com.abang.cart.bean.Product;
import com.abang.cart.service.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @RequestMapping(value = "/getProduct", method = RequestMethod.GET)
    public String getProduct(HttpServletRequest request) {
        Logger logger = Logger.getLogger(ProductController.class);
        logger.info(request.getParameter("name"));
        List<Product> products = productService.getProdectDao();
        logger.info(products);
        request.setAttribute("products", products);
        return "listProduct";
    }
}
