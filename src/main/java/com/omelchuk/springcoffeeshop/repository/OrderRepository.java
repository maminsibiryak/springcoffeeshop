package com.omelchuk.springcoffeeshop.repository;

import com.omelchuk.springcoffeeshop.model.Customer;
import com.omelchuk.springcoffeeshop.model.CustomerOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<CustomerOrder, Long> {


}
