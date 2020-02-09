package com.bondhan.bospring.bootstrap;

import com.bondhan.bospring.domain.Author;
import com.bondhan.bospring.domain.Book;
import com.bondhan.bospring.domain.Publisher;
import com.bondhan.bospring.repositories.AuthorRepository;
import com.bondhan.bospring.repositories.BookRepository;
import com.bondhan.bospring.repositories.PublisherRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner{

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository){
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        
        Author bondhan = new Author("Bondhan", "Novandy");
        Book encyclo = new Book("Africa Jungle", "122312323");        
        bondhan.getBooks().add(encyclo);
        encyclo.getAuthors().add(bondhan);

        authorRepository.save(bondhan);
        bookRepository.save(encyclo);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "32143424334");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        Publisher pub = new Publisher("bonpub","kodja 2", "Depok", "Jawa Barat", "16425");
        pub.getBooks().add(encyclo);
        pub.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(pub);

        System.out.println("Started in Bootstrap");        
        System.out.println("Number of Books:" + bookRepository.count());
        System.out.println("Number of Publisher:" + publisherRepository.count());
        System.out.println("Publisher number of books:" + pub.getBooks().size());

    }
    
}