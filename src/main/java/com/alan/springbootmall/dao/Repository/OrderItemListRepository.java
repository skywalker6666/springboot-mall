package com.alan.springbootmall.dao.Repository;

import com.alan.springbootmall.model.OrderItem;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

/**
 * @author alan9
 **/
public interface OrderItemListRepository extends ListCrudRepository<OrderItem, Integer> {
    List<OrderItem> getOrderItemByOrderId(Integer orderId);
}
