package com.market.project.onlinemarket.serviceImpl;

import com.market.project.onlinemarket.entity.Category;
import com.market.project.onlinemarket.entity.Product;
import com.market.project.onlinemarket.repository.CategoryRepository;
import com.market.project.onlinemarket.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository repository;
    @Override
    public List<Category> getAllCategories() {
        return repository.findAll();
    }

    @Override
    public Category updateOrSaveCategory(Category category) {
        return repository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        Optional<Category> categoryControl=repository.findById(id);
        if (categoryControl.isPresent()){
            repository.deleteById(id);
        }else
            throw new RuntimeException();
    }

    @Override
    public List<Product> getProductsByCategoryId(Long categoryId) {
        Category category=repository.findById(categoryId).orElse(null);
        if (category==null){
            throw new NotFoundException("Category is not found!");
        }
        return category.getProductList();
    }
}
