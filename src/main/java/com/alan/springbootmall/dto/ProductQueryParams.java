package com.alan.springbootmall.dto;

import com.alan.springbootmall.constant.ProductCategory;
import org.springframework.data.domain.Sort;

/**
 * @author alan9
 **/
public class ProductQueryParams {
    ProductCategory category;
    String search;
   Sort sort;

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

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
