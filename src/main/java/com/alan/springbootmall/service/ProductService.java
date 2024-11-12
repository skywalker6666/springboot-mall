package com.alan.springbootmall.service;

import com.alan.springbootmall.dto.ProductRequest;
import com.alan.springbootmall.model.Product;

/**
 * @author alan9
 **/
public interface ProductService {
    public Product getProductById(int id);
    public Integer createProduct(ProductRequest productRequest);
}
