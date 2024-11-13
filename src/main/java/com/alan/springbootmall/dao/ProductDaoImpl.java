package com.alan.springbootmall.dao;

import com.alan.springbootmall.dto.ProductRequest;
import com.alan.springbootmall.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;

/**
 * @author alan9
 **/
@Component
public class ProductDaoImpl implements ProductDao {
    @Autowired
    ProductRepository productRepository;

    public Product getProductById(int productId) {
        return productRepository.findByProductId(productId);
    }

    public Integer createProduct(ProductRequest productRequest) {
        Product product = new Product();

        product.setProductName(productRequest.getProductName());
        product.setCategory(productRequest.getCategory());
        product.setImageUrl(productRequest.getImageUrl());
        product.setPrice(productRequest.getPrice());
        product.setStock(productRequest.getStock());
        product.setDescription(productRequest.getDescription());

        Timestamp currentTimestamp = Timestamp.from(Instant.now());
        product.setCreatedDate(currentTimestamp);
        product.setLastModifiedDate(currentTimestamp);

        Product savedProduct = productRepository.save(product);
        return savedProduct.getProductId();
    }

    public void updateProduct(int id, ProductRequest productRequest) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setProductName(productRequest.getProductName());
        product.setCategory(productRequest.getCategory());
        product.setImageUrl(productRequest.getImageUrl());
        product.setPrice(productRequest.getPrice());
        product.setStock(productRequest.getStock());
        product.setDescription(productRequest.getDescription());
        Timestamp currentTimestamp = Timestamp.from(Instant.now());
        product.setLastModifiedDate(currentTimestamp);
        productRepository.save(product);
    }
    public void deleteProduct(int id){
        productRepository.deleteById(id);
    }
}
