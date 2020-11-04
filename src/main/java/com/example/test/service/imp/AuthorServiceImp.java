package com.example.test.service.imp;

import com.example.test.domain.Author;
import com.example.test.repository.AuthorRepository;
import com.example.test.service.AuthorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class AuthorServiceImp implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImp(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Page<Author> getAll(Pageable pageable) {
        return authorRepository.findAll(pageable);
    }

    @Override
    public Optional<Author> findOne(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }
}
