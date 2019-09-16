package com.abang.cart.service;

import com.abang.cart.bean.Product;
import com.abang.cart.dao.ProdectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProdectDao prodectDao;
    public List<Product> getProdects() {
        return prodectDao.ListProduct();
    }

    public Product getProdect(int id) {
        return prodectDao.getProduct(id);
    }

}
