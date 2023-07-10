package com.market.project.onlinemarket.service;

import com.market.project.onlinemarket.entity.Customer;

public interface CustomerService {
    Customer saveOrUpdateCustomer(Customer customer);

    boolean purchaseProduct(Long customerId, Long productId);

}
