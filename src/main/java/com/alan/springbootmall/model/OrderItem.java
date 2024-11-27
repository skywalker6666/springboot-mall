package com.alan.springbootmall.model;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * @author alan9
 **/
@Entity
@Table(name = "order_item", schema = "mall", catalog = "postgres")
public class OrderItem {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "order_item_id")
    private int orderItemId;
    @Basic
    @Column(name = "order_id")
    private int orderId;
    @Basic
    @Column(name = "product_id")
    private int productId;
    @Basic
    @Column(name = "quantity")
    private int quantity;
    @Basic
    @Column(name = "amount")
    private int amount;

    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return orderItemId == orderItem.orderItemId && orderId == orderItem.orderId && productId == orderItem.productId && quantity == orderItem.quantity && amount == orderItem.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderItemId, orderId, productId, quantity, amount);
    }
}
