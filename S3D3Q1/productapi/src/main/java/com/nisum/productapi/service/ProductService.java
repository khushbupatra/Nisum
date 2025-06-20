
package com.nisum.productapi.service;

import com.nisum.productapi.model.Product;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);
    public ProductService() {
        products.add(new Product(idGenerator.getAndIncrement(), "Laptop", 999.99));
        products.add(new Product(idGenerator.getAndIncrement(), "Mouse", 25.50));
        products.add(new Product(idGenerator.getAndIncrement(), "Keyboard", 75.00));
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }
    public Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }

    public Product createProduct(Product product) {
        product.setId(idGenerator.getAndIncrement());
        products.add(product);
        return product;
    }

    public Optional<Product> updateProduct(Long id, Product updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getId().equals(id)) {
                updatedProduct.setId(id);
                products.set(i, updatedProduct);
                return Optional.of(updatedProduct);
            }
        }
        return Optional.empty();
    }
    public boolean deleteProduct(Long id) {
        return products.removeIf(product -> product.getId().equals(id));
    }
}
