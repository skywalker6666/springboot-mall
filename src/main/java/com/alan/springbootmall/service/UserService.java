package com.alan.springbootmall.service;

import com.alan.springbootmall.dto.UserLoginRequest;
import com.alan.springbootmall.dto.UserRegisterRequest;
import com.alan.springbootmall.model.User;
import org.springframework.stereotype.Component;

/**
 * @author alan9
 **/
@Component
public interface UserService {
    Integer register(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);

    User login(UserLoginRequest userLoginRequest);
}
