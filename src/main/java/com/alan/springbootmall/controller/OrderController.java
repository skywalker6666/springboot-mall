package com.alan.springbootmall.controller;

import com.alan.springbootmall.dto.CreateOrderRequest;
import com.alan.springbootmall.dto.OrderQueryParams;
import com.alan.springbootmall.dto.ProductQueryParams;
import com.alan.springbootmall.model.Orders;
import com.alan.springbootmall.model.Product;
import com.alan.springbootmall.service.OrderService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
        Orders order = orderService.getOrderById(orderId);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

    @Validated
    @GetMapping("/users/{userId}/orders")
    public ResponseEntity<List<Orders>> getOrders(
            @PathVariable int userId,
            //Filtering
            @RequestParam(required = false) String search,
            //Sorting
            @RequestParam(defaultValue = "DESC") String sortOrder,
            @RequestParam(defaultValue = "createdDate") String sortField,
            //Pagination
            @RequestParam(defaultValue = "0") @Max(1000) @Min(0) Integer page,
            @RequestParam(defaultValue = "5") @Min(0) Integer size
    ) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortOrder), sortField);
        Pageable pageable = PageRequest.of(page, size, sort);
        OrderQueryParams orderQueryParams = new OrderQueryParams();
        orderQueryParams.setUserId(userId);
        orderQueryParams.setSearch(search);
        orderQueryParams.setPageable(pageable);
        List<Orders> orders = orderService.getOrders(orderQueryParams);

        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }

    @GetMapping("/allOrder")
    public List<Orders> getAllOrder() {
        return orderService.getAllOrder();
    }
}





