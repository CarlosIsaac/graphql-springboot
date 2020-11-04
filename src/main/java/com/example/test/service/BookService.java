package com.example.test.service;

import com.example.test.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BookService {

    Book save(Book book);
    Page<Book> findAll(Pageable pageable);
    Optional<Book> findOne(Long id);
    void delete(Long id);
}
