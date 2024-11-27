package com.alan.springbootmall.service.impl;

import com.alan.springbootmall.dao.UserDao;
import com.alan.springbootmall.dto.UserLoginRequest;
import com.alan.springbootmall.dto.UserRegisterRequest;
import com.alan.springbootmall.model.User;
import com.alan.springbootmall.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.web.server.ResponseStatusException;

/**
 * @author alan9
 **/
@Component
public class UserServiceImpl implements UserService {
    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    UserDao userDao;

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        //檢查註冊之email
        User user = userDao.getUserByEmail(userRegisterRequest.getEmail());
        if (user != null) {
            logger.warn("email：{}已被註冊", userRegisterRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        //使用md5生成pwd雜湊值
        String hashedPwd = DigestUtils.md5DigestAsHex(userRegisterRequest.getPassword().getBytes());
        userRegisterRequest.setPassword(hashedPwd);
        //創建新帳號
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public User login(UserLoginRequest userLoginRequest) {
        User user = userDao.getUserByEmail(userLoginRequest.getEmail());
        //檢查user是否存在
        if (null == user) {
            logger.warn("email:{}尚未註冊", userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        //使用md5生成pwd雜湊值
        String hashedPwd = DigestUtils.md5DigestAsHex(userLoginRequest.getPassword().getBytes());
        //比較密碼
        if (user.getPassword().equals(hashedPwd)) {
            return user;
        } else {
            logger.warn("email:{}，密碼不正確", userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}