package com.abang.cart.bean;

import org.springframework.stereotype.Component;

@Component
public class ProductItem {
    private int id;
    private int num;
    private Product product;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductItem{" +
                "id=" + id +
                ", num=" + num +
                ", product=" + product +
                '}';
    }
}
