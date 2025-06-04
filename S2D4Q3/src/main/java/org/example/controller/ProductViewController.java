package org.example.controller;

import org.example.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductViewController {

    private final ProductService productService;

    public ProductViewController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api/products")
    public ModelAndView showAllProducts() {
        return new ModelAndView("products", "products", productService.getAllProducts());

    }
}