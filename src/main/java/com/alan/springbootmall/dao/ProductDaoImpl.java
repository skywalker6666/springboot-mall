package com.alan.springbootmall.dao;

import com.alan.springbootmall.dao.Repository.ProductListRepository;
import com.alan.springbootmall.dao.Repository.ProductRepository;
import com.alan.springbootmall.dto.ProductQueryParams;
import com.alan.springbootmall.dto.ProductRequest;
import com.alan.springbootmall.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
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
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<Product> getProducts(ProductQueryParams productQueryParams) {
        if (productQueryParams.getCategory() != null && productQueryParams.getSearch() != null) {
            return productListRepository.findByCategoryAndProductNameContainingOrCategoryAndDescriptionContaining(productQueryParams.getCategory(), productQueryParams.getSearch(), productQueryParams.getCategory(), productQueryParams.getSearch(), productQueryParams.getPageable());
        } else if (productQueryParams.getCategory() != null) {
            return productListRepository.findByCategory(productQueryParams.getCategory(), productQueryParams.getPageable());
        } else if (productQueryParams.getSearch() != null) {
            return productListRepository.findByProductNameContainingOrDescriptionContaining(productQueryParams.getSearch(), productQueryParams.getSearch(), productQueryParams.getPageable());
        } else {
            return productListRepository.findAll(productQueryParams.getPageable()); // 查詢所有產品
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

    @Override
    public void updateStockById(int id,int stock) {
        Query query = em.createQuery("UPDATE Product p SET p.stock = :stock WHERE p.id = :id");
        query.setParameter("stock", stock);
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
