package com.omelchuk.springcoffeeshop.controller;

import com.omelchuk.springcoffeeshop.model.Book;
import com.omelchuk.springcoffeeshop.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
    @Autowired
    private BookRepository bookRepository;

@RequestMapping (value = "bookmanager/addbook", method = RequestMethod.GET)
public String allBook(Model model){
    model.addAttribute("listBook", bookRepository.findAll());
    return "bookmanager/addbook";
}


    @RequestMapping(value = "/bookmanager/addbook", method = RequestMethod.POST)
    @ResponseBody
    public String addBook(@RequestParam String bookTitle, @RequestParam String bookAuthor, @RequestParam Double price){
        Book book = new Book();
        book.setBookTitle(bookTitle);
        book.setBookAuthor(bookAuthor);
        book.setPrice(price);
        bookRepository.save(book);
        return "bookmanager/addbook";
    }

    /*@RequestMapping(value = "/bookmanager/addbook", method = RequestMethod.POST)
    @ResponseBody
    public String saveProduct(@RequestBody Book book) {
        bookRepository.save(book);
        return "/bookmanager/addbook";
    }*/


}
