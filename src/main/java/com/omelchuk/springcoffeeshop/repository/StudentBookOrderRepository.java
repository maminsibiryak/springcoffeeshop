package com.omelchuk.springcoffeeshop.repository;

import com.omelchuk.springcoffeeshop.model.StudentBookOrder;
import org.springframework.data.repository.CrudRepository;

public interface StudentBookOrderRepository extends CrudRepository<StudentBookOrder, Long>{
}
