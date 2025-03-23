package com.design.framework.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.design.framework.user.dao.UserDao;
import com.design.framework.user.model.User;
import com.design.framework.user.service.UserService;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public int delete(Integer user_id ) {
        return this.userDao.delete(user_id);
    }

    @Override
    public int add(User user ) {
        return this.userDao.add(user);
    }

    @Override
    public User load(Integer user_id ) {
        return this.userDao.load(user_id);
    }

    @Override
    public int update(User user ) {
        return this.userDao.update(user);
    }

    @Override
    public User login(String account , String password ) {
        User user = this.userDao.login(account , password);
        if(user==null){
            throw new RuntimeException ("用户名或者密码错误,请重新登录!");
        }else{
            return user;
        }
    }

    @Override
    public List<User> list() {
        return this.userDao.list();
    }

    @Override
    public boolean checkAccount(String account ) {
        User user = this.userDao.loadAccount(account);
        if(user==null){
            return true;
        }else{
            return false;
        }
    }
}
