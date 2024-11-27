package com.alan.springbootmall.dao;


import com.alan.springbootmall.dao.Repository.OrderRepository;
import com.alan.springbootmall.model.Orders;
import com.alan.springbootmall.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author alan9
 **/
@Component
public class OrderDaoImpl implements OrderDao {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public Integer createOrder(Integer userId, Integer totalAmount) {
        Orders orders = new Orders(userId, totalAmount);
        try {
            return orderRepository.save(orders).getOrderId();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create orders", e);
        }
    }

    @Override
    public void createOrderItem(Integer orderId, List<OrderItem> orderItemList) {

    }
}
