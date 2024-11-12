package com.alan.springbootmall.dao;

import com.alan.springbootmall.dto.ProductRequest;
import com.alan.springbootmall.model.Product;

/**
 * @author alan9
 **/
public interface ProductDao {
    public Product getProductById(int productId);
    public Integer createProduct(ProductRequest productRequest);
}
