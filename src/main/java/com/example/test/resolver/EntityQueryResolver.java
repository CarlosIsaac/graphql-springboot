package com.example.test.resolver;

import com.example.test.domain.Author;
import com.example.test.domain.Book;
import com.example.test.domain.Publisher;
import com.example.test.service.AuthorService;
import com.example.test.service.BookService;
import com.example.test.service.PublisherService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EntityQueryResolver implements GraphQLQueryResolver {

    private final PublisherService publisherService;
    private final AuthorService authorService;
    private final BookService bookService;

    public EntityQueryResolver(PublisherService publisherService, AuthorService authorService,
                               BookService bookService) {
        this.publisherService = publisherService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    public Publisher getPublisherById(Long id) {
        try {
            Optional<Publisher> publisher = publisherService.findOne(id);
            if (publisher.isPresent()) {
                return publisher.get();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    public Author getAuthorById(Long id) {
        try {
            Optional<Author> author = authorService.findOne(id);
            if (author.isPresent()) {
                author.get().getBooks();
                return author.get();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    public Book getBookById(Long id) {
        try {
            Optional<Book> book = bookService.findOne(id);
            if (book.isPresent()) {
                return book.get();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }
}

