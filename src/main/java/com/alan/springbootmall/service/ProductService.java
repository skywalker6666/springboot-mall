package com.alan.springbootmall.service;

import com.alan.springbootmall.dto.ProductQueryParams;
import com.alan.springbootmall.dto.ProductRequest;
import com.alan.springbootmall.model.Product;

import java.util.List;

/**
 * @author alan9
 **/
public interface ProductService {
    List<Product> getProducts(ProductQueryParams productQueryParams);

    Product getProductById(int id);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(int id, ProductRequest productRequest);

    void deleteProductById(int id);
}
