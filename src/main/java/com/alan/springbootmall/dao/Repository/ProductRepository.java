package com.alan.springbootmall.dao.Repository;

import com.alan.springbootmall.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author alan9
 **/
@Component
public interface ProductRepository extends CrudRepository<Product, Integer> {
    public Product findByProductId(Integer productId);

}
