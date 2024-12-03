package com.alan.springbootmall.controller;

import com.alan.springbootmall.dto.CreateOrderRequest;
import com.alan.springbootmall.model.Orders;
import com.alan.springbootmall.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author alan9
 **/
@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("users/{userId}/orders")
    public ResponseEntity<?> createOrder(@PathVariable int userId, @RequestBody @Valid CreateOrderRequest createOrderRequest) {
        Integer orderId = orderService.createOrder(userId, createOrderRequest);
        Orders order=orderService.getOrderById(orderId);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }
    @GetMapping("/allOrder")
    public List<Orders> getAllOrder() {
        return orderService.getAllOrder();
    }
}
