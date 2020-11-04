package com.example.test.service.imp;

import com.example.test.domain.Publisher;
import com.example.test.repository.PublisherRepository;
import com.example.test.service.PublisherService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class PublisherServiceImp implements PublisherService {

    private final PublisherRepository publisherRepository;

    public PublisherServiceImp(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Publisher save(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public Page<Publisher> findAll(Pageable pageable) {
        return publisherRepository.findAll(pageable);
    }

    @Override
    public Optional<Publisher> findOne(Long id) {
        return publisherRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        publisherRepository.deleteById(id);
    }
}
