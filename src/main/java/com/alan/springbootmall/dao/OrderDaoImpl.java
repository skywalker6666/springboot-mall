package com.alan.springbootmall.dao;


import com.alan.springbootmall.dao.Repository.OrderItemListRepository;
import com.alan.springbootmall.dao.Repository.OrderRepository;
import com.alan.springbootmall.dto.OrderItemProductDto;
import com.alan.springbootmall.model.Orders;
import com.alan.springbootmall.model.OrderItem;
import com.alan.springbootmall.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
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
    @Autowired
    OrderItemListRepository orderItemListRepository;
    @PersistenceContext
    private EntityManager entityManager;

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
        for (OrderItem orderItem : orderItemList) {
            orderItem.setOrderId(orderId);
            entityManager.persist(orderItem);
        }
    }

    @Override
    public Orders getOrderById(Integer orderId) {
        return orderRepository.getOrdersByOrderId(orderId);
    }

    @Override
    public List<OrderItemProductDto> getOrderItemByOrderId(Integer orderId) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<OrderItemProductDto> query = builder.createQuery(OrderItemProductDto.class);
        Root<OrderItem> orderItemRoot = query.from(OrderItem.class);
        Join<OrderItem, Product> product = orderItemRoot.join("product");
        query.select(builder.construct(
                OrderItemProductDto.class,
                orderItemRoot.get("orderItemId"),
                orderItemRoot.get("orderId"),
                orderItemRoot.get("productId"),
                orderItemRoot.get("quantity"),
                orderItemRoot.get("amount"),
                product.get("productName"), // 僅選取需要的欄位
                product.get("imageUrl")    // 僅選取需要的欄位
        )).where(builder.equal(orderItemRoot.get("orderId"), orderId));
        List<OrderItemProductDto> orderItemProductDtoList = entityManager.createQuery(query).getResultList();
        System.out.println("DTO size:" + orderItemProductDtoList.size());
        return orderItemProductDtoList;
    }

    @Override
    public List<Orders> getAllOrder() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Orders> query = builder.createQuery(Orders.class);
        Root<Orders> orders = query.from(Orders.class);
        query.select(orders);
        return entityManager.createQuery(query).getResultList();
    }
}
