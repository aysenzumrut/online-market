package com.market.project.onlinemarket.controller;

import com.market.project.onlinemarket.builder.ProductSpecificationBuilder;
import com.market.project.onlinemarket.dto.ProductSearchDTO;
import com.market.project.onlinemarket.dto.SearchCriteria;
import com.market.project.onlinemarket.entity.Product;
import com.market.project.onlinemarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/get-all")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }

    @PutMapping("/save-or-update")
    public Product saveOrUpdate(@RequestBody Product product) {
        return service.saveOrUpdateProduct(product);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam Long id) {
        try {
            service.deleteProduct(id);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The Product is Not Found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body("The Product is Deleted.");
    }

    @PostMapping("/search-product")
    public List<Product> getByDynamicCriteria(@RequestBody ProductSearchDTO productSearchDTO) {
        ProductSpecificationBuilder builder = new ProductSpecificationBuilder();
        List<SearchCriteria> fieldList = productSearchDTO.getSearchCriteriaList();
        if (fieldList != null) {
            fieldList.forEach(
                    searchCriteria -> {
                        searchCriteria.setDataOption(productSearchDTO.getDataOption());
                        builder.with(searchCriteria);
                    }
            );
        }
        return service.getByDynamicCriteria(builder.build());
    }

}
