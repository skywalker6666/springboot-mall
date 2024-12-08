package com.alan.springbootmall.dao.Repository;

import com.alan.springbootmall.model.Orders;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

/**
 * @author alan9
 **/
public interface OrderListRepository extends ListCrudRepository<Orders,Integer> {

    List<Orders> getOrdersByUserId(Integer userId);
}
