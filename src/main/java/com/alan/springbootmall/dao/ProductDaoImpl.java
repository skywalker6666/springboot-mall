package com.alan.springbootmall.dao;

import com.alan.springbootmall.dao.Repository.ProductListRepository;
import com.alan.springbootmall.dao.Repository.ProductRepository;
import com.alan.springbootmall.dto.ProductQueryParams;
import com.alan.springbootmall.dto.ProductRequest;
import com.alan.springbootmall.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

/**
 * @author alan9
 **/
@Component
public class ProductDaoImpl implements ProductDao {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductListRepository productListRepository;

    @Override
    public List<Product> getProducts(ProductQueryParams productQueryParams) {
        if (productQueryParams.getCategory() != null && productQueryParams.getSearch() != null) {
            return productListRepository.findByCategoryAndProductNameContainingOrCategoryAndDescriptionContaining(productQueryParams.getCategory(), productQueryParams.getSearch(), productQueryParams.getCategory(), productQueryParams.getSearch());
        } else if (productQueryParams.getCategory() != null) {
            return productListRepository.findByCategoryOrderByProductIdAsc(productQueryParams.getCategory());
        } else if (productQueryParams.getSearch() != null) {
            return productListRepository.findByProductNameContainingOrDescriptionContainingOrderByProductIdAsc(productQueryParams.getSearch(), productQueryParams.getSearch());
        } else {
            return productListRepository.findAll(); // 查詢所有產品
        }
    }

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

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}
