package com.example.demo.repo;

import com.example.demo.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Book, Long> {
}
