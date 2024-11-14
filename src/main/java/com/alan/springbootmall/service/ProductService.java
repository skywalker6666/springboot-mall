package com.alan.springbootmall.service;

import com.alan.springbootmall.dto.ProductRequest;
import com.alan.springbootmall.model.Product;

import java.util.List;

/**
 * @author alan9
 **/
public interface ProductService {
    public List<Product> getProducts();
    public Product getProductById(int id);
    public Integer createProduct(ProductRequest productRequest);
    public void updateProduct(int id, ProductRequest productRequest);
    public void deleteProductById(int id);
}
