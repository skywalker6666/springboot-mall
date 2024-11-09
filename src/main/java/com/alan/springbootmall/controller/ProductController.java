package com.alan.springbootmall.controller;

import com.alan.springbootmall.model.Product;
import com.alan.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alan9
 **/
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/products/{productId}")
    public ResponseEntity<Product>getProduct(@PathVariable Integer productId){
        Product product=productService.getProductById(productId);
        if (null!=product){
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
