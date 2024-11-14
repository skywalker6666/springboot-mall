package com.alan.springbootmall.dao.Repository;

import com.alan.springbootmall.model.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author alan9
 **/
@Component
public interface ProductListRepository extends ListCrudRepository<Product,Integer> {
    public List<Product> findAllByOrderByProductIdAsc();
}
