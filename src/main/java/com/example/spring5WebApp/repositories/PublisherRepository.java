package com.example.spring5WebApp.repositories;

import com.example.spring5WebApp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
