package com.alan.springbootmall.dao;

import com.alan.springbootmall.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

}
