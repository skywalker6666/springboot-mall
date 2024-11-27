package com.alan.springbootmall.dto;

/**
 * @author alan9
 **/
public class BuyItem {
    private Integer productId;
    private Integer quantity;

    public BuyItem(Integer productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public BuyItem() {
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "BuyItem{" +
                "productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
