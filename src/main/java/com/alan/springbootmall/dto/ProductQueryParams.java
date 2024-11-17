package com.alan.springbootmall.dto;

import com.alan.springbootmall.constant.ProductCategory;
import org.springframework.data.domain.Pageable;

/**
 * @author alan9
 **/
public class ProductQueryParams {
    ProductCategory category;
    String search;

    public Pageable getPageable() {
        return pageable;
    }

    public void setPageable(Pageable pageable) {
        this.pageable = pageable;
    }

    Pageable pageable;


    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
