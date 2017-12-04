package com.omelchuk.springcoffeeshop.repository;

import com.omelchuk.springcoffeeshop.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
