package com.project.restapi.service;

import com.project.restapi.model.Product;
import com.project.restapi.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();

    public List<Product> getAll() {
        return products;
    }

    public Product getById(int id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not found"));
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public boolean updateProduct(int id, Product updatedProduct) {
        Product existing = getById(id);
        products.remove(existing);
        updatedProduct.setId(id);
        products.add(updatedProduct);
        return true;
    }

    public boolean deleteProduct(int id) {
        Product existing = getById(id);
        return products.remove(existing);
    }
}
