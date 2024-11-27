package com.alan.springbootmall.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author alan9
 **/
@Entity
public class Orders {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "order_id")
    private int orderId;
    @Basic
    @Column(name = "user_id")
    private int userId;
    @Basic
    @Column(name = "total_amount")
    private int totalAmount;
    @CreationTimestamp
    @Column(name = "created_date", nullable = false, updatable = false)
    private Timestamp createdDate;
    @UpdateTimestamp
    @Column(name = "last_modified_date", nullable = false)
    private Timestamp lastModifiedDate;

    public Orders(int userId, int totalAmount) {
        this.userId = userId;
        this.totalAmount = totalAmount;
    }

    public Orders() {

    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Timestamp lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return orderId == orders.orderId && userId == orders.userId && totalAmount == orders.totalAmount && Objects.equals(createdDate, orders.createdDate) && Objects.equals(lastModifiedDate, orders.lastModifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, userId, totalAmount, createdDate, lastModifiedDate);
    }
}
