package com.alan.springbootmall.dao;

import com.alan.springbootmall.dto.ProductQueryParams;
import com.alan.springbootmall.dto.ProductRequest;
import com.alan.springbootmall.model.Product;

import java.util.List;

/**
 * @author alan9
 **/
public interface ProductDao {

    List<Product> getProducts(ProductQueryParams productQueryParams);

    Product getProductById(int productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(int id, ProductRequest productRequest);

    void deleteProduct(int id);

}
