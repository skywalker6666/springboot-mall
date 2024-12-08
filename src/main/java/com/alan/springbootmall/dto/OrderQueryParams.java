package com.alan.springbootmall.dto;

import com.alan.springbootmall.constant.ProductCategory;
import org.springframework.data.domain.Pageable;

/**
 * @author alan9
 **/
public class OrderQueryParams {
    Integer userId;
    String search;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Pageable getPageable() {
        return pageable;
    }

    public void setPageable(Pageable pageable) {
        this.pageable = pageable;
    }

    Pageable pageable;


    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
