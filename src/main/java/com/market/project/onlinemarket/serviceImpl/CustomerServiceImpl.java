package com.market.project.onlinemarket.serviceImpl;

import com.market.project.onlinemarket.entity.Customer;
import com.market.project.onlinemarket.entity.Product;
import com.market.project.onlinemarket.repository.CustomerRepository;
import com.market.project.onlinemarket.service.CustomerService;
import com.market.project.onlinemarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductService productService;

    @Override
    public Customer saveOrUpdateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public boolean purchaseProduct(Long customerId, Long productId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        Product product = productService.getProductById(productId);

        if (customer == null || product == null) {
            return false;
        }

        BigDecimal remainingBudget = customer.getBudget().subtract(product.getPrice());
        int remainingStock = product.getStock() - 1;

        if (remainingBudget.compareTo(BigDecimal.ZERO) >= 0 && remainingStock >= 0) {
            customer.getPurchasedProducts().add(product);
            customer.setBudget(remainingBudget);
            product.setStock(remainingStock);

            customerRepository.save(customer);
            productService.saveOrUpdateProduct(product);

            return true;
        }

        return false;
    }
}
