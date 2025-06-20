package com.project.restapi.q1.controller;

import com.project.restapi.q1.entity.Customer;
import com.project.restapi.q1.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepo;

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerRepo.save(customer);
    }

    @GetMapping("/{id}")
    public Optional<Customer> getCustomerById(@PathVariable Long id) {
        return customerRepo.findById(id);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerRepo.deleteById(id);
    }
}
