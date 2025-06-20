package com.customer.dashboard.service;

import com.customer.dashboard.entity.Product;
import com.customer.dashboard.exception.ProductNotFoundException;
import com.customer.dashboard.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> getAll() {
        return repo.findAll();
    }

    public Product getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID " + id));
    }

    public Product add(Product product) {
        return repo.save(product);
    }

    public Product update(Long id, Product updated) {
        Product product = getById(id);
        product.setName(updated.getName());
        product.setDescription(updated.getDescription());
        product.setPrice(updated.getPrice());
        product.setStockQuantity(updated.getStockQuantity());
        product.setCategory(updated.getCategory());
        return repo.save(product);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
