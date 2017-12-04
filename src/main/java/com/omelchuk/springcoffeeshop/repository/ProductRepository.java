package com.omelchuk.springcoffeeshop.repository;

import com.omelchuk.springcoffeeshop.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

 public List<Product> findByProductName(String productName);
}
