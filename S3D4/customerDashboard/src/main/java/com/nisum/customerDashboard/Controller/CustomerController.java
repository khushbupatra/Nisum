package com.nisum.customerDashboard.controller;

import com.nisum.customerDashboard.entity.Customer;
import com.nisum.customerDashboard.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return service.addCustomer(customer);
    }

    @GetMapping("/{id}")
    public Optional<Customer> getCustomerById(@PathVariable Long id) {
        return service.getCustomerById(id);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        service.deleteCustomer(id);
    }

    @GetMapping("/search/email/{email}")
    public List<Customer> searchByEmail(@PathVariable String email) {
        return service.searchByEmail(email);
    }

    @GetMapping("/filter/registered-after/{date}")
    public List<Customer> getCustomersRegisteredAfter(@PathVariable String date) {
        return service.getCustomersRegisteredAfter(LocalDate.parse(date));
    }

    @GetMapping("/search/{name}")
    public List<Customer> findByName(@PathVariable String name) {
        return service.findByName(name);
    }

}
