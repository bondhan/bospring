package com.bondhan.bospring.repositories;

import org.springframework.data.repository.CrudRepository;
import com.bondhan.bospring.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
    
}