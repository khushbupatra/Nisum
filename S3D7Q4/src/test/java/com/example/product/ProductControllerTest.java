package com.example.product.controller;

import com.example.product.entity.Product;
import com.example.product.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Optional;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static java.nio.file.Files.delete;
import static javax.swing.UIManager.put;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        productRepository.deleteAll();
    }

    @Test
    void testAddProduct() throws Exception {
        Product product = new Product();
        product.setName("iPhone");
        product.setDescription("Smartphone");
        product.setPrice(new BigDecimal("999.99"));
        product.setStockQuantity(10);
        product.setCategory("Electronics");

        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(product)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("iPhone")));
    }

    @Test
    void testGetAllProducts() throws Exception {
        Product product = new Product();
        product.setName("Laptop");
        product.setDescription("Gaming Laptop");
        product.setPrice(new BigDecimal("1500.00"));
        product.setStockQuantity(5);
        product.setCategory("Electronics");

        productRepository.save(product);

        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("Laptop")));
    }

    @Test
    void testGetProductById() throws Exception {
        Product product = new Product();
        product.setName("Tablet");
        product.setDescription("Android Tablet");
        product.setPrice(new BigDecimal("300.00"));
        product.setStockQuantity(15);
        product.setCategory("Electronics");

        Product saved = productRepository.save(product);

        mockMvc.perform(get("/products/" + saved.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Tablet")));
    }

    @Test
    void testUpdateProduct() throws Exception {
        Product product = new Product();
        product.setName("Watch");
        product.setDescription("Smart Watch");
        product.setPrice(new BigDecimal("199.99"));
        product.setStockQuantity(20);
        product.setCategory("Gadgets");

        Product saved = productRepository.save(product);

        saved.setPrice(new BigDecimal("179.99"));
        saved.setStockQuantity(25);

        mockMvc.perform(put("/products/" + saved.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(saved)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price", is(179.99)));
    }

    @Test
    void testDeleteProduct() throws Exception {
        Product product = new Product();
        product.setName("Camera");
        product.setDescription("DSLR Camera");
        product.setPrice(new BigDecimal("799.99"));
        product.setStockQuantity(7);
        product.setCategory("Photography");

        Product saved = productRepository.save(product);

        mockMvc.perform(delete("/products/" + saved.getId()))
                .andExpect(status().isOk());

        Optional<Product> deleted = productRepository.findById(saved.getId());
        assert(deleted.isEmpty());
    }
}
