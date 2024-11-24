package com.alan.springbootmall.service.impl;

import com.alan.springbootmall.dao.UserDao;
import com.alan.springbootmall.dto.UserRegisterRequest;
import com.alan.springbootmall.model.User;
import com.alan.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author alan9
 **/
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }
}
