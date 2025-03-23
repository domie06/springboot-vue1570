package com.design.framework.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.design.framework.user.model.User;



public interface UserDao {
    int delete(Integer user_id);
    
    int add(User user);
    
    User load(Integer user_id);

    User loadAccount(String account);
    
    int update(User user);

    User login( @Param("account") String account,@Param("password") String password);
    
    List<User> list();
}