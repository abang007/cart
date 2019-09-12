package com.abang.cart.service;

import com.abang.cart.bean.Product;
import com.abang.cart.dao.ProdectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {
    @Autowired
    ProdectDao prodectDao;
    public List<Product> getProdectDao() {
        return prodectDao.ListProduct();
    }

}
