package com.alan.springbootmall.dao.Repository;

import com.alan.springbootmall.constant.ProductCategory;
import com.alan.springbootmall.model.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author alan9
 **/
@Component
public interface ProductListRepository extends ListCrudRepository<Product, Integer> {

    List<Product> findByProductNameContainingOrDescriptionContaining(String productNameKeyWord, String descriptionKeyWord, Sort sort);

    List<Product> findByCategory(ProductCategory category, Sort sort);

    List<Product> findByCategoryAndProductNameContainingOrCategoryAndDescriptionContaining(
            ProductCategory category, String nameKeyword, ProductCategory categoryAgain, String descriptionKeyword, Sort sort);

    List<Product> findAll(Sort sort);

}
