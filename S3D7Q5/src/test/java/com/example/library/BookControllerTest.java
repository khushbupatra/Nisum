package com.example.library;

import com.example.library.entity.Book;
import com.example.library.repository.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookRepository bookRepo;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        bookRepo.deleteAll();
    }

    @Test
    void testAddBook() throws Exception {
        Book book = new Book(null, "Java Basics", "Author A", 2023);
        mockMvc.perform(post("/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is("Java Basics")));
    }

    @Test
    void testGetAllBooks() throws Exception {
        Book book = new Book(null, "Spring Boot", "Author B", 2022);
        bookRepo.save(book);

        mockMvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title", is("Spring Boot")));
    }

    @Test
    void testGetBookById() throws Exception {
        Book book = new Book(null, "Hibernate", "Author C", 2021);
        Book saved = bookRepo.save(book);

        mockMvc.perform(get("/books/" + saved.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is("Hibernate")));
    }

    @Test
    void testUpdateBook() throws Exception {
        Book book = new Book(null, "Old Title", "Author X", 2018);
        Book saved = bookRepo.save(book);

        saved.setTitle("Updated Title");

        mockMvc.perform(put("/books/" + saved.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(saved)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is("Updated Title")));
    }

    @Test
    void testDeleteBook() throws Exception {
        Book book = new Book(null, "To Delete", "Author Y", 2019);
        Book saved = bookRepo.save(book);

        mockMvc.perform(delete("/books/" + saved.getId()))
                .andExpect(status().isOk());
    }
}
