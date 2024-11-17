package com.alan.springbootmall.controller;

import com.alan.springbootmall.constant.ProductCategory;
import com.alan.springbootmall.dto.ProductQueryParams;
import com.alan.springbootmall.dto.ProductRequest;
import com.alan.springbootmall.model.Product;
import com.alan.springbootmall.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author alan9
 **/
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(@RequestParam(required = false) ProductCategory category,
                                                     @RequestParam(required = false) String search,
                                                     @RequestParam(defaultValue = "DESC") String sortOrder,
                                                     @RequestParam(defaultValue = "createdDate") String sortField
                                                     ) {
        Sort sort=Sort.by(Sort.Direction.fromString(sortOrder),sortField);
        ProductQueryParams productQueryParams = new ProductQueryParams();
        productQueryParams.setCategory(category);
        productQueryParams.setSearch(search);
        productQueryParams.setSort(sort);
        List<Product> products = productService.getProducts(productQueryParams);
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId) {
        Product product = productService.getProductById(productId);
        if (null != product) {
            return ResponseEntity.status(HttpStatus.OK).body(product);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest) {
        Integer productId = productService.createProduct(productRequest);
        Product product = productService.getProductById(productId);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);

    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId, @RequestBody @Valid ProductRequest productRequest) {
        //檢查product是否存在
        Product product = productService.getProductById(productId);
        if (null == product) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        productService.updateProduct(productId, productRequest);
        Product updatedProduct = productService.getProductById(productId);
        return ResponseEntity.status(HttpStatus.OK).body(updatedProduct);

    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId) {
        productService.deleteProductById(productId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
