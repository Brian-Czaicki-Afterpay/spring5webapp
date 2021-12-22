package com.example.spring5WebApp.repositories;

import com.example.spring5WebApp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
