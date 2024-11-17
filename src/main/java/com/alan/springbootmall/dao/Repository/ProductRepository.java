package com.alan.springbootmall.dao.Repository;

import com.alan.springbootmall.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;


/**
 * @author alan9
 **/
@Component
public interface ProductRepository extends CrudRepository<Product, Integer> {
    Product findByProductId(Integer productId);

}
