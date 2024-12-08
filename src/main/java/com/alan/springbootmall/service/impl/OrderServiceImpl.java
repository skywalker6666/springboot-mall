package com.alan.springbootmall.service.impl;

import com.alan.springbootmall.dao.OrderDao;
import com.alan.springbootmall.dao.ProductDao;
import com.alan.springbootmall.dto.BuyItem;
import com.alan.springbootmall.dto.CreateOrderRequest;
import com.alan.springbootmall.dto.OrderItemProductDto;
import com.alan.springbootmall.dto.OrderQueryParams;
import com.alan.springbootmall.model.OrderItem;
import com.alan.springbootmall.model.Orders;
import com.alan.springbootmall.model.Product;
import com.alan.springbootmall.service.OrderService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author alan9
 **/
@Component
public class OrderServiceImpl implements OrderService {
    private final static Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    OrderDao orderDao;
    @Autowired
    ProductDao productDao;

    @Transactional
    @Override
    public Integer createOrder(int userId, CreateOrderRequest createOrderRequest) {
        int totalAmount = 0;
        List<OrderItem> orderItemList = new ArrayList<>();
        System.out.println("size:" + createOrderRequest.getBuyItemList().size());
        for (BuyItem buyItem : createOrderRequest.getBuyItemList()) {
            System.out.println(buyItem.toString());
            Product product = productDao.getProductById(buyItem.getProductId());
            //檢查商品是否存在
            if (null == product) {
                logger.warn("商品{}不存在", buyItem.getProductId());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

            }
            //檢查庫存是否足夠
            else if (product.getStock() < buyItem.getQuantity()) {
                logger.warn("商品{}庫存不足，無法購買。剩餘庫存:{}，欲購買數量:{}", product.getProductId(), product.getStock(), buyItem.getQuantity());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }
            //扣除商品庫存
            productDao.updateStockById(buyItem.getProductId(), product.getStock() - buyItem.getQuantity());
            //計算總價錢
            int amount = buyItem.getQuantity() * product.getPrice();
            totalAmount += amount;
            //轉換buyItem to orderItem
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(buyItem.getProductId());
            orderItem.setQuantity(buyItem.getQuantity());
            orderItem.setAmount(amount);
            orderItemList.add(orderItem);
        }
        System.out.println("orderItemList size:" + orderItemList.size());
        Integer orderId = orderDao.createOrder(userId, totalAmount);
        orderDao.createOrderItem(orderId, orderItemList);
        return orderId;
    }

    @Override
    public Orders getOrderById(Integer orderId) {
        Orders orders = orderDao.getOrderById(orderId);
        List<OrderItemProductDto> orderItemList = orderDao.getOrderItemByOrderId(orderId);
        orders.setOrderItemList(orderItemList);
        return orders;
    }

    @Override
    public List<Orders> getAllOrder() {
        return orderDao.getAllOrder();
    }

    @Override
    public List<Orders> getOrders(OrderQueryParams orderQueryParams) {
        List<Orders> ordersList = orderDao.getOrdersByUserId(orderQueryParams.getUserId());
        for (Orders orders : ordersList) {
            List<OrderItemProductDto> orderItemProductDtoList = orderDao.getOrderItemByOrderId(orders.getOrderId());
            orders.setOrderItemList(orderItemProductDtoList);
        }
        return ordersList;
    }
}
