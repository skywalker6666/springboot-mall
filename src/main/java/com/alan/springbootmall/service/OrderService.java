package com.alan.springbootmall.service;

import com.alan.springbootmall.dto.CreateOrderRequest;

/**
 * @author alan9
 **/
public interface OrderService {
    Integer createOrder(int userId, CreateOrderRequest createOrderRequest);
}
