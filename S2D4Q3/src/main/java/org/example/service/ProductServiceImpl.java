package org.example.service;

import org.example.dao.ProductDAO;
import org.example.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDao;

    public ProductServiceImpl(ProductDAO productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getAllProducts() {
        return productDao.getAll();
    }

    @Override
    public Product getProductById(int id) {
        return productDao.getById(id);
    }

    @Override
    public void saveProduct(Product product) {

    }

    @Override
    public void addProduct(Product product) {
        productDao.save(product);
    }

    @Override
    public void updateProduct(Product product) {
        productDao.update(product);
    }

    @Override
    public void deleteProduct(int id) {
        productDao.delete(id);
    }
}
