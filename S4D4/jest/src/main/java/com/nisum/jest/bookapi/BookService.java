package com.nisum.jest.bookapi;

import org.springframework.stereotype.Service;

@Service
public class BookService {
    public Book getBookById(Long id) {
        throw new BookNotFoundException(id);
    }
}
