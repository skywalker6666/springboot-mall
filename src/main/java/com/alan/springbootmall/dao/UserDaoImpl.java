package com.alan.springbootmall.dao;

import com.alan.springbootmall.dao.Repository.UserRepository;
import com.alan.springbootmall.dto.UserRegisterRequest;
import com.alan.springbootmall.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @author alan9
 **/
@Component
public class UserDaoImpl implements UserDao {
    @Autowired
    UserRepository userRepository;

    @Override
    public Integer createUser(UserRegisterRequest userRegisterRequest) {
        User user = new User(userRegisterRequest.getEmail(), userRegisterRequest.getPassword());
        try {
            return userRepository.save(user).getUserId();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create user", e);
        }
    }

    @Override
    public User getUserById(Integer userId) {
        return userRepository.getUserByUserId(userId);
    }
}
