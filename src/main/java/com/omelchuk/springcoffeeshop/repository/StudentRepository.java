package com.omelchuk.springcoffeeshop.repository;

import com.omelchuk.springcoffeeshop.model.Student;
import com.omelchuk.springcoffeeshop.model.StudentBookOrder;
import org.springframework.data.repository.CrudRepository;

import java.security.acl.LastOwnerException;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
