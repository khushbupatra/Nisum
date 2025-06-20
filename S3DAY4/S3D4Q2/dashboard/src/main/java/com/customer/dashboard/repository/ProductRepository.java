package com.customer.dashboard.repository;

import com.customer.dashboard.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory(String category);

    List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);

    List<Product> findByNameContainingIgnoreCase(String name);

    @Query("SELECT p FROM Product p WHERE p.name = ?1 AND p.category = ?2")
    List<Product> findByNameAndCategory(String name, String category);
}
