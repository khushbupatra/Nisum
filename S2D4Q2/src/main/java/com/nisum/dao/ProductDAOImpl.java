package com.nisum.dao;

import com.nisum.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Product p) {
        String sql = "INSERT INTO products (name, category, price) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, p.getName(), p.getCategory(), p.getPrice());
    }

    @Override
    public void update(Product p) {
        String sql = "UPDATE products SET name=?, category=?, price=? WHERE id=?";
        jdbcTemplate.update(sql, p.getName(), p.getCategory(), p.getPrice(), p.getId());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM products WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Product get(int id) {
        String sql = "SELECT * FROM products WHERE id=?";
        return jdbcTemplate.queryForObject(
                sql,
                new BeanPropertyRowMapper<>(Product.class),
                id
        );
    }

    @Override
    public List<Product> list() {
        String sql = "SELECT * FROM products";
        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(Product.class)
        );
    }
}