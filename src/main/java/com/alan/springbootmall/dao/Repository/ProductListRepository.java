package com.alan.springbootmall.dao.Repository;

import com.alan.springbootmall.constant.ProductCategory;
import com.alan.springbootmall.model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author alan9
 **/
@Component
public interface ProductListRepository extends ListCrudRepository<Product, Integer> {

    List<Product> findByProductNameContainingOrDescriptionContaining(String productNameKeyWord, String descriptionKeyWord, Pageable pageable);

    List<Product> findByCategory(ProductCategory category, Pageable pageable);

    List<Product> findByCategoryAndProductNameContainingOrCategoryAndDescriptionContaining(
            ProductCategory category, String nameKeyword, ProductCategory categoryAgain, String descriptionKeyword, Pageable pageable);

    List<Product> findAll(Pageable pageable);

}
