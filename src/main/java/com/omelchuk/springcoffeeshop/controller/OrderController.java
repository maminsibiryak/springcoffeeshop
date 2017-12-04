package com.omelchuk.springcoffeeshop.controller;

import com.omelchuk.springcoffeeshop.model.Customer;
import com.omelchuk.springcoffeeshop.model.CustomerOrder;
import com.omelchuk.springcoffeeshop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.omelchuk.springcoffeeshop.repository.CustomerRepository;
import com.omelchuk.springcoffeeshop.repository.OrderRepository;
import com.omelchuk.springcoffeeshop.repository.ProductRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class OrderController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String productList(Model model){
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("orders", orderRepository.findAll());
        Customer customer = new Customer();

        List<Customer> customerList = customerRepository.findCustomerOrderByLastName("Omelchuk");
        model.addAttribute("listCustomer", customerList);
        return "orders";
    }

    @RequestMapping(value = "/createorder", method = RequestMethod.POST)
    @ResponseBody
    public String saveOrder(@RequestParam String firstName, @RequestParam String lastName, @RequestParam(value = "productIds[]") Long[] productIds, @RequestParam Double money){
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setMoney(money);
        customerRepository.save(customer);
        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setCustomer(customerRepository.findOne(customer.getCustomerId()));
        Set<Product> productSet = new HashSet<Product>();
        for (Long productId: productIds
             ) {productSet.add(productRepository.findOne(productId));

        }
        customerOrder.setProducts(productSet);
        Double total = 0.0;
        for (Long productId:productIds
             ) {
            total= total+(productRepository.findOne(productId).getProductPrice());

        }
        customerOrder.setOddMoney(money-total);
        customerOrder.setTotal(total);
        orderRepository.save(customerOrder);
        return customerOrder.getOrderId().toString();
    }
    @RequestMapping(value = "/removeorder", method = RequestMethod.POST)
    @ResponseBody
    public String removeOrder(@RequestParam Long Id){
        orderRepository.delete(Id);

        return Id.toString();
    }
}
