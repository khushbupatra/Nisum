package com.library.restapi.service;

import com.library.restapi.exception.BookNotFoundException;
import com.library.restapi.model.Book;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class BookService {

    private static final List<Book> books = new ArrayList<>();
    private static final AtomicLong counter = new AtomicLong();

    public List<Book> getAllBooks(String author, Integer year, int page, int size) {
        List<Book> filtered = books.stream()
                .filter(book -> (author == null || book.getAuthor().equalsIgnoreCase(author)) &&
                        (year == null || book.getPublishedYear().equals(year)))
                .collect(Collectors.toList());

        int start = Math.min(page * size, filtered.size());
        int end = Math.min(start + size, filtered.size());

        return filtered.subList(start, end);
    }

    public Book getBookById(Long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException("Book not found with ID " + id));
    }

    public Book addBook(Book book) {
        book.setId(counter.incrementAndGet());
        books.add(book);
        return book;
    }

    public Book updateBook(Long id, Book updated) {
        Book existing = getBookById(id);
        existing.setTitle(updated.getTitle());
        existing.setAuthor(updated.getAuthor());
        existing.setPublishedYear(updated.getPublishedYear());
        return existing;
    }

    public void deleteBook(Long id) {
        Book book = getBookById(id);
        books.remove(book);
    }
}
