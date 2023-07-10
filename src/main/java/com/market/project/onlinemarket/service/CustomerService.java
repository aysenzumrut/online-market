package com.market.project.onlinemarket.service;

import com.market.project.onlinemarket.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer saveOrUpdateCustomer(Customer customer);

    boolean purchaseProduct(Long customerId, Long productId);

    List<Customer> getAll();
}
