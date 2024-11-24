package com.alan.springbootmall.dao.Repository;

import com.alan.springbootmall.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 * @author alan9
 **/
@Component
public interface UserRepository extends CrudRepository<User, Integer> {
    User getUserByUserId(Integer userId);
}
