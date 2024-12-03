package com.alan.springbootmall.dto;

/**
 * @author alan9
 **/
public class OrderItemProductDto {
    private int orderItemId;
    private int orderId;
    private int productId;
    private int quantity;
    private int amount;
    private String productName; // 只需要的欄位
    private String imageUrl;    // 只需要的欄位

    public OrderItemProductDto() {
    }

    public OrderItemProductDto(int orderItemId, int orderId, int productId, int quantity, int amount, String productName, String imageUrl) {
        this.orderItemId = orderItemId;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.amount = amount;
        this.productName = productName;
        this.imageUrl = imageUrl;
    }

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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
// Getters and Setters
}
