package com.alan.springbootmall.service.impl;

import com.alan.springbootmall.dao.ProductDao;
import com.alan.springbootmall.model.Product;
import com.alan.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author alan9
 **/
@Component
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public Product getProductById(int id) {
        return productDao.getProductById(id);
    }
}
