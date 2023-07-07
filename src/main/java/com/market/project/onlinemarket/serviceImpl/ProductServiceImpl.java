package com.market.project.onlinemarket.serviceImpl;

import com.market.project.onlinemarket.entity.Product;
import com.market.project.onlinemarket.repository.ProductRepository;
import com.market.project.onlinemarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public Product saveOrUpdateProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        Optional<Product> productControl = repository.findById(id);
        if (productControl.isPresent()) {
            repository.deleteById(id);
        } else throw new RuntimeException();
    }
}
