package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
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
        System.out.println("Started in Bootstrap");

        Publisher publisher=new Publisher();
        publisher.setName("Cahaya");
        publisher.setCity("Jakarta");
        publisher.setState("Jaksel");

        publisherRepository.save(publisher);

        System.out.println("Number of publisher "+publisherRepository.count());



        Author eric= new Author("Eric", "Evan");
        Book ddd= new Book ("Domain Driven Design", "123123");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author daniel = new Author("Daniel", "Liang");
        Book java=new Book("Java 11", "1235578");

        daniel.getBooks().add(java);
        java.getAuthors().add(daniel);

        java.setPublisher(publisher);
        publisher.getBooks().add(java);

        authorRepository.save(daniel);
        bookRepository.save(java);
        publisherRepository.save(publisher);


        System.out.println("Number of Book "+bookRepository.count());
        System.out.println("Publisher number of books : "+publisher.getBooks().size());



    }


}

