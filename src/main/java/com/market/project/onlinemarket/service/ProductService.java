package com.market.project.onlinemarket.service;

import com.market.project.onlinemarket.entity.Category;
import com.market.project.onlinemarket.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product saveOrUpdateProduct(Product product);
    void deleteProduct(Long id);
}
