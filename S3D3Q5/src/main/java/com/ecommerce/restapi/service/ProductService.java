package com.ecommerce.restapi.service;

import com.ecommerce.restapi.exception.ProductNotFoundException;
import com.ecommerce.restapi.model.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private static final List<Product> productList = new ArrayList<>();
    private static final AtomicLong counter = new AtomicLong();

    public List<Product> getAll(String category, BigDecimal minPrice, BigDecimal maxPrice, int page, int size, String sortField, String sortDir) {
        Comparator<Product> comparator = Comparator.comparing(Product::getId); // default
        if ("price".equalsIgnoreCase(sortField)) {
            comparator = Comparator.comparing(Product::getPrice);
        } else if ("name".equalsIgnoreCase(sortField)) {
            comparator = Comparator.comparing(Product::getName);
        }

        if ("desc".equalsIgnoreCase(sortDir)) {
            comparator = comparator.reversed();
        }

        List<Product> filtered = productList.stream()
                .filter(p -> (category == null || p.getCategory().equalsIgnoreCase(category)) &&
                        (minPrice == null || p.getPrice().compareTo(minPrice) >= 0) &&
                        (maxPrice == null || p.getPrice().compareTo(maxPrice) <= 0))
                .sorted(comparator)
                .collect(Collectors.toList());

        int start = Math.min(page * size, filtered.size());
        int end = Math.min(start + size, filtered.size());

        return filtered.subList(start, end);
    }

    public Product getById(Long id) {
        return productList.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + id));
    }

    public Product add(Product product) {
        product.setId(counter.incrementAndGet());
        productList.add(product);
        return product;
    }

    public Product update(Long id, Product updated) {
        Product existing = getById(id);
        existing.setName(updated.getName());
        existing.setDescription(updated.getDescription());
        existing.setPrice(updated.getPrice());
        existing.setStockQuantity(updated.getStockQuantity());
        existing.setCategory(updated.getCategory());
        return existing;
    }

    public void delete(Long id) {
        Product product = getById(id);
        productList.remove(product);
    }
}
