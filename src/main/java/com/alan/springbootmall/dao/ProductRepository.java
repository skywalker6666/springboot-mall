package com.alan.springbootmall.dao;

import com.alan.springbootmall.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 * @author alan9
 **/
@Component
public interface ProductRepository extends CrudRepository<Product, Integer> {
    public Product findByProductId(Integer productId);
}
