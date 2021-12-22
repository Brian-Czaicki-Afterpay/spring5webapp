package com.example.spring5WebApp.repositories;

import com.example.spring5WebApp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
