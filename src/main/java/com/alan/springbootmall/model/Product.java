package com.alan.springbootmall.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author alan9
 **/
@Entity
public class Product {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "product_id")
    private int productId;
    @Basic
    @Column(name = "product_name")
    private String productName;
    @Basic
    @Column(name = "category")
    private String category;
    @Basic
    @Column(name = "image_url")
    private String imageUrl;
    @Basic
    @Column(name = "price")
    private int price;
    @Basic
    @Column(name = "stock")
    private int stock;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "created_date")
    private Timestamp createdDate;
    @Basic
    @Column(name = "last_modified_date")
    private Timestamp lastModifiedDate;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Timestamp lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId && price == product.price && stock == product.stock && Objects.equals(productName, product.productName) && Objects.equals(category, product.category) && Objects.equals(imageUrl, product.imageUrl) && Objects.equals(description, product.description) && Objects.equals(createdDate, product.createdDate) && Objects.equals(lastModifiedDate, product.lastModifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, category, imageUrl, price, stock, description, createdDate, lastModifiedDate);
    }
}
