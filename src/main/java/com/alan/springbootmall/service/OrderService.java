package com.alan.springbootmall.service;

import com.alan.springbootmall.dto.CreateOrderRequest;
import com.alan.springbootmall.model.Orders;

import java.util.List;

/**
 * @author alan9
 **/
public interface OrderService {
    Integer createOrder(int userId, CreateOrderRequest createOrderRequest);

    Orders getOrderById(Integer orderId);

    List<Orders> getAllOrder();
}
