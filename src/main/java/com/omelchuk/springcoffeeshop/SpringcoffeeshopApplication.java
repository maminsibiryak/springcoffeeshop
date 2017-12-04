package com.omelchuk.springcoffeeshop;

import com.omelchuk.springcoffeeshop.model.Product;
import com.omelchuk.springcoffeeshop.repository.CustomerRepository;
import com.omelchuk.springcoffeeshop.repository.OrderRepository;
import com.omelchuk.springcoffeeshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringcoffeeshopApplication implements CommandLineRunner {
	@Autowired
	ProductRepository productRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	OrderRepository orderRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringcoffeeshopApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		/*Product mocha = new Product();
		mocha.setProductName("Mocha");
		mocha.setProductPrice(3.95);

		Product capuccinno = new Product();
		capuccinno.setProductName("Capuccinno");
		capuccinno.setProductPrice(4.95);

		productRepository.save(mocha);
		productRepository.save(capuccinno);*/
		for (Product pr: productRepository.findByProductName("mocha")
			 ) {
			System.out.println(pr.getProductName());
		}
	}
}
