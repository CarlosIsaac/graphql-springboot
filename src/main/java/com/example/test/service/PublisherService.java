package com.example.test.service;

import com.example.test.domain.Publisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PublisherService {

    Publisher save(Publisher publisher);
    Page<Publisher> findAll(Pageable pageable);
    Optional<Publisher> findOne(Long id);
    void delete(Long id);
}
