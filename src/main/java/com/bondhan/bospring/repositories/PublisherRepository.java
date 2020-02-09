package com.bondhan.bospring.repositories;

import org.springframework.data.repository.CrudRepository;
import com.bondhan.bospring.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
    
}