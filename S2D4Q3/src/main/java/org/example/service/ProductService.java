package org.example.service;

import org.example.model.Product;
import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(int id);
    void updateProduct(Product product);
    void deleteProduct(int id);

    void saveProduct(Product product);

    void addProduct(Product product);
}