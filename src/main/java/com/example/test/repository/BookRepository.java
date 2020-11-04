package com.example.test.repository;

import com.example.test.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unused")
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
