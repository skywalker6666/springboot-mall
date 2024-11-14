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

    public List<Product> findByProductNameContainingOrDescriptionContainingOrderByProductIdAsc(String productNameKeyWord, String descriptionKeyWord);

    public List<Product> findByCategoryOrderByProductIdAsc(ProductCategory category);

    public List<Product> findByCategoryAndProductNameContainingOrCategoryAndDescriptionContaining(
            ProductCategory category, String nameKeyword, ProductCategory categoryAgain, String descriptionKeyword);

    public List<Product> findByOrderByProductIdAsc();

}
