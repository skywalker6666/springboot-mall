package com.alan.springbootmall.service.impl;

import com.alan.springbootmall.constant.ProductCategory;
import com.alan.springbootmall.dao.ProductDao;
import com.alan.springbootmall.dto.ProductRequest;
import com.alan.springbootmall.model.Product;
import com.alan.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author alan9
 **/
@Component
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getProducts(ProductCategory category,String search) {
        return productDao.getProducts(category,search);
    }

    @Override
    public Product getProductById(int id) {
        return productDao.getProductById(id);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }

    @Override
    public void updateProduct(int id, ProductRequest productRequest) {
         productDao.updateProduct(id,productRequest);
    }

    @Override
    public void deleteProductById(int id) {
        productDao.deleteProduct(id);
    }
}
