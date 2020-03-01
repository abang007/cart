package com.abang.cart.dao;

import com.abang.cart.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    public String getUser(String name);

    public void insertUser(User user);

    public String getUserName(String name);
}
