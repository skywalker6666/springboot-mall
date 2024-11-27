package com.alan.springbootmall.dao.Repository;

import com.alan.springbootmall.model.Orders;
import org.springframework.data.repository.CrudRepository;

/**
 * @author alan9
 **/
public interface OrderRepository extends CrudRepository<Orders,Integer> {

}
