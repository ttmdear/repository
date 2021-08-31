package comjgexampleA.bootstrap;

import comjgexampleA.model.Author;
import comjgexampleA.model.Book;
import comjgexampleA.model.Publisher;
import comjgexampleA.repositories.AuthorRepository;
import comjgexampleA.repositories.BookRepository;
import comjgexampleA.repositories.PublisherRepository;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @EventListener()
    public void handleContextStartedEvent(ContextRefreshedEvent event) {
        // Herlion
        Publisher publisher = new Publisher("Helion", "ul.Jana Olbrachta 29A/1, Warszawa");

        publisherRepository.save(publisher);

        // Eric
        Author eric = new Author("Eric", "Evans");

        Book ddd = new Book("Domain-Driven Design", "9788328305250", publisher);

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        Author john = new Author("John", "Lakos");

        Book b1 = new Book("Large-Scale C++", "0201717069", publisher);
        Book b2 = new Book("Cabin by the Creek", "1420888773", publisher);

        john.getBooks().add(b1);
        john.getBooks().add(b2);

        b1.getAuthors().add(john);
        b2.getAuthors().add(john);

        authorRepository.save(eric);
        authorRepository.save(john);

        bookRepository.save(b1);
        bookRepository.save(b2);
        bookRepository.save(ddd);
    }
}
