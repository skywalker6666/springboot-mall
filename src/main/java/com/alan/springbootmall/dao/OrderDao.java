package com.alan.springbootmall.dao;

import com.alan.springbootmall.dto.OrderItemProductDto;
import com.alan.springbootmall.model.OrderItem;
import com.alan.springbootmall.model.Orders;

import java.util.List;

/**
 * @author alan9
 **/
public interface OrderDao {
    Integer createOrder(Integer userId, Integer totalAmount);

    void createOrderItem(Integer orderId, List<OrderItem> orderItemList);

    Orders getOrderById(Integer orderId);

    List<OrderItemProductDto> getOrderItemByOrderId(Integer orderId);

    List<Orders> getAllOrder();
}
