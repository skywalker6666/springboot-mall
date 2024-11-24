package com.alan.springbootmall.dao;

import com.alan.springbootmall.dto.UserRegisterRequest;
import com.alan.springbootmall.model.User;

/**
 * @author alan9
 **/
public interface UserDao {
    Integer createUser(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);
}
