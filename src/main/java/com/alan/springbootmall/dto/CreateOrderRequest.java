package com.alan.springbootmall.dto;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;

/**
 * @author alan9
 **/
public class CreateOrderRequest {
    @NotEmpty
    private List<BuyItem> buyItemList;

    public List<BuyItem> getBuyItemList() {
        return buyItemList;
    }

    public void setBuyItemList(List<BuyItem> buyItemList) {
        this.buyItemList = buyItemList;
    }

    public CreateOrderRequest() {
    }

    public CreateOrderRequest(List<BuyItem> buyItemList) {
        this.buyItemList = buyItemList;
    }
}
