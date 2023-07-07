package com.market.project.onlinemarket.controller;

import com.market.project.onlinemarket.entity.Category;
import com.market.project.onlinemarket.entity.Product;
import com.market.project.onlinemarket.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping("/get-all") //LISTED ALL CATEGORIES
    public ResponseEntity<List<Category>> getAllCategories() {
        return new ResponseEntity<>(service.getAllCategories(), HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProductsByCategory(@RequestParam Long categoryId){
        List<Product> products=service.getProductsByCategoryId(categoryId);
        return ResponseEntity.ok(products);
    }

    @PutMapping("/save-or-update") //IF ID IS EXIST UPDATE, NOT SAVE CATEGORY
    public Category updateOrSaveCategory(@RequestBody Category category) {
        return service.updateOrSaveCategory(category);
    }

    @DeleteMapping("/delete") //IF CATEGORY ID IS EXIST DELETE, NOT THROW ERROR
    public ResponseEntity<String> deleteCategory(@RequestParam Long id) {
        try {
            service.deleteCategory(id);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The Category is Not Found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body("The Category is Deleted.");
    }
}
