package com.library.restapi.controller;

import com.library.restapi.model.Book;
import com.library.restapi.service.BookService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public List<Book> getBooks(
            @RequestParam(required = false) String author,
            @RequestParam(required = false) Integer publishedYear,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return service.getAllBooks(author, publishedYear, page, size);
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return service.getBookById(id);
    }

    @PostMapping
    public Book addBook(@Valid @RequestBody Book book) {
        return service.addBook(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @Valid @RequestBody Book book) {
        return service.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        service.deleteBook(id);
    }
}
