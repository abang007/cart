package com.abang.cart.dao;

import com.abang.cart.bean.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProdectDao {
    public List<Product> ListProduct();

    public Product getProduct(int id);
}
