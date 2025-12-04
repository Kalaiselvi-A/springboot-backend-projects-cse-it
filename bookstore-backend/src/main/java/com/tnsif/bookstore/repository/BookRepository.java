package com.tnsif.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tnsif.bookstore.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
