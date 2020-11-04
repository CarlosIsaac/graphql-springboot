package com.example.test.resolver;

import com.example.test.domain.Author;
import com.example.test.domain.Book;
import com.example.test.domain.Publisher;
import com.example.test.service.AuthorService;
import com.example.test.service.BookService;
import com.example.test.service.PublisherService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class EntityMutationResolver implements GraphQLMutationResolver {

    private final PublisherService publisherService;
    private final AuthorService authorService;
    private final BookService bookService;

    public EntityMutationResolver(PublisherService publisherService, AuthorService authorService, BookService bookService) {
        this.publisherService = publisherService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    public Publisher addPublisher(Publisher newPublisher) throws Exception {
        Publisher publisher = new Publisher();
        publisher.setName(newPublisher.getName());
        return publisherService.save(publisher);
    }

    public Author addAuthor(Author newAuthor) throws Exception {
        Author author = new Author();
        author.setName(newAuthor.getName());
        author.setPublisher(publisherService.findOne(newAuthor.getPublisher().getId()).get());
        return authorService.save(author);
    }

    public Book addBook(Book newBook) throws Exception {
        Book book = new Book();
        book.setTitle(newBook.getTitle());
        book.setISBN(newBook.getISBN());
        book.setAuthor(authorService.findOne(newBook.getAuthor().getId()).get());
        book.setPublisher(publisherService.findOne(newBook.getPublisher().getId()).get());
        return bookService.save(book);

    }

}
