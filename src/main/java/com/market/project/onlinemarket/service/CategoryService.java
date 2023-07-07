package com.market.project.onlinemarket.service;

import com.market.project.onlinemarket.entity.Category;
import com.market.project.onlinemarket.entity.Product;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category updateOrSaveCategory(Category category);
    void deleteCategory(Long id);
    List<Product> getProductsByCategoryId(Long categoryId);
}
