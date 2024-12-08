package com.alan.springbootmall.service;

import com.alan.springbootmall.dto.CreateOrderRequest;
import com.alan.springbootmall.dto.OrderQueryParams;
import com.alan.springbootmall.model.Orders;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author alan9
 **/
@Component
public interface OrderService {
    Integer createOrder(int userId, CreateOrderRequest createOrderRequest);

    Orders getOrderById(Integer orderId);

    List<Orders> getAllOrder();

    List<Orders> getOrders(OrderQueryParams orderQueryParams);
}
