package com.bondhan.bospring.bootstrap;

import com.bondhan.bospring.domain.Author;
import com.bondhan.bospring.domain.Book;
import com.bondhan.bospring.repositories.AuthorRepository;
import com.bondhan.bospring.repositories.BookRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner{

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository){
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
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

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started in Bootstrap");        
        System.out.println("Number of Books:" + bookRepository.count());


    }
    
}