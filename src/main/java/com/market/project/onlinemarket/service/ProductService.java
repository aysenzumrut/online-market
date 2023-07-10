package com.market.project.onlinemarket.service;

import com.market.project.onlinemarket.entity.Product;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product saveOrUpdateProduct(Product product);

    void deleteProduct(Long id);

    Product getProductById(Long productId);

    List<Product> getByDynamicCriteria(Specification<Product> specification);
}
