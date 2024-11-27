package com.alan.springbootmall.controller;

import com.alan.springbootmall.dto.CreateOrderRequest;
import com.alan.springbootmall.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
        return ResponseEntity.status(HttpStatus.CREATED).body(orderId);
    }
}
