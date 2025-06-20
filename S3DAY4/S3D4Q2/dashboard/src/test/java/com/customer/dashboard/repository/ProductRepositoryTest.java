package com.customer.dashboard.repository;

import com.customer.dashboard.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository repo;

    @Test
    void testFindByCategory() {
        Product p = new Product();
        p.setName("Laptop");
        p.setCategory("Electronics");
        p.setPrice(BigDecimal.valueOf(50000));
        repo.save(p);

        List<Product> result = repo.findByCategory("Electronics");
        assertFalse(result.isEmpty());
    }
}
