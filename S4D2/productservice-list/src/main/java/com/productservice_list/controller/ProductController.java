package com.productservice_list.controller;

import com.productservice_list.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products/list")
public class ProductController {

    @GetMapping
    public List<Product> getAllProducts() {
        return List.of(
                new Product(1L, "Skyline Hoodie", 1999),
                new Product(2L, "Classic Baseball Cap", 799),
                new Product(3L, "Premium Cotton Shirt", 1499),
                new Product(4L, "Biker's Denim Jacket", 3999),
                new Product(5L, "Urban Backpack", 2499)
        );
    }
}
