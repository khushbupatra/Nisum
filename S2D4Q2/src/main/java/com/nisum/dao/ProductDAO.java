package com.nisum.dao;

import com.nisum.model.Product;
import java.util.List;

public interface ProductDAO {
    void save(Product p);
    void update(Product p);
    void delete(int id);
    Product get(int id);
    List<Product> list();
}
