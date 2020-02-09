package com.bondhan.bospring.repositories;

import org.springframework.data.repository.CrudRepository;
import com.bondhan.bospring.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}