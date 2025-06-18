package com.nisum.customerDashboard.service;

import com.nisum.customerDashboard.entity.Customer;
import com.nisum.customerDashboard.repository.CustomerRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepo repository;

    public CustomerService(CustomerRepo repository) {
        this.repository = repository;
    }

    public Customer addCustomer(Customer customer) {
        return repository.save(customer);
    }

    public Optional<Customer> getCustomerById(Long id) {
        return repository.findById(id);
    }

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public void deleteCustomer(Long id) {
        repository.deleteById(id);
    }

    public List<Customer> searchByEmail(String keyword) {
        return repository.findByEmailContaining(keyword);
    }

    public List<Customer> getCustomersRegisteredAfter(LocalDate date) {
        return repository.findByRegisteredDateAfter(date);
    }

    public List<Customer> findByName(String name) {
        return repository.findByName(name);
    }
}
