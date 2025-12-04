package com.tnsif.bookstore.service;

import com.tnsif.bookstore.entity.Book;
import com.tnsif.bookstore.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // CREATE
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    // READ ALL
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // READ BY ID
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    // UPDATE
    public Book updateBook(Long id, Book bookData) {
        Book b = getBookById(id);

        b.setTitle(bookData.getTitle());
        b.setAuthor(bookData.getAuthor());
        b.setPrice(bookData.getPrice());
        b.setIsbn(bookData.getIsbn());
        b.setCategory(bookData.getCategory());
        b.setStock(bookData.getStock());

        return bookRepository.save(b);
    }

    // DELETE
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
