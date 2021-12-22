package com.example.spring5WebApp.bootstrap;

import com.example.spring5WebApp.domain.Author;
import com.example.spring5WebApp.domain.Book;
import com.example.spring5WebApp.domain.Publisher;
import com.example.spring5WebApp.repositories.AuthorRepository;
import com.example.spring5WebApp.repositories.BookRepository;
import com.example.spring5WebApp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author brian = new Author("Brian", "Czaicki");
        Book ddd = new Book("Domain Driven Design", "1234");

        brian.getBooks().add(ddd);
        ddd.getAuthors().add(brian);

        authorRepository.save(brian);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444");
        Publisher worx = new Publisher(
                "Worx",
                "579 Broadway",
                ",
                "New York",
                "NY",
                "10011",
                "US"
        );

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        worx.getBooks().add(noEJB);
        worx.getBooks().add(ddd);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(worx);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Authors: " + authorRepository.count());
        System.out.println("Number of books." + bookRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
        System.out.println("Number of Publisher books " + worx.getBooks().size());


    }
}
