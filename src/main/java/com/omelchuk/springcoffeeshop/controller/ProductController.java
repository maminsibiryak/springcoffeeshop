package com.omelchuk.springcoffeeshop.controller;

import com.omelchuk.springcoffeeshop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.omelchuk.springcoffeeshop.repository.ProductRepository;

@Controller
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @RequestMapping("/product/{id}")
    public String product(@PathVariable Long id, Model model){
        model.addAttribute("product", productRepository.findOne(id));
        return "product";
    }
    @RequestMapping(value = "/products",method = RequestMethod.GET)
    public String productsList(Model model){
        model.addAttribute("products", productRepository.findAll());
        return "products";
    }
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public String all(Model model){
        model.addAttribute("products", productRepository.findAll());
        return "all";
    }

    @RequestMapping(value = "/saveproduct", method = RequestMethod.POST)
    @ResponseBody
    public String saveProduct(@RequestBody Product product) {
        productRepository.save(product);
        return product.getProductId().toString();
    }
}
