package com.design.framework.user.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.design.framework.user.model.User;

public interface UserService {
    
    int delete(Integer user_id);

    int add(User user);

    User load(Integer user_id);

    int update(User user);
    
    User login( @Param("account") String account,@Param("password") String password);

    List<User> list();


    boolean checkAccount(String account);
}
