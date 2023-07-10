package com.market.project.onlinemarket.controller;

import com.market.project.onlinemarket.entity.Customer;
import com.market.project.onlinemarket.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    CustomerService service;

    @GetMapping("/get-all")
    public List<Customer> getAll(){
        return service.getAll();
    }

    @PutMapping("/save-or-update")
    public Customer saveOrUpdate(@RequestBody Customer customer) {
        return service.saveOrUpdateCustomer(customer);
    }

    @PostMapping("/purchase-product")
    public ResponseEntity<String> purchaseProduct(@RequestParam Long customerId, @RequestParam Long productId) {
        boolean purchased = service.purchaseProduct(customerId, productId);
        if (purchased) {
            return ResponseEntity.ok("Ürün başarıyla satın alındı.");
        } else {
            return ResponseEntity.badRequest().body("Ürün satın alınamadı.");
        }
    }
}
