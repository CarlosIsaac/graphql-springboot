package com.example.test.service;

import com.example.test.domain.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface AuthorService {

    Author save(Author author);
    Page<Author> getAll(Pageable pageable);
    Optional<Author> findOne(Long id);
    void delete(Long id);
}
