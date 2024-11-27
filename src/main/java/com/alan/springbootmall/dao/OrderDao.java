package com.alan.springbootmall.dao;

import com.alan.springbootmall.model.OrderItem;

import java.util.List;

/**
 * @author alan9
 **/
public interface OrderDao {
    Integer createOrder(Integer userId, Integer totalAmount);

    void createOrderItem(Integer orderId, List<OrderItem> orderItemList);
}
