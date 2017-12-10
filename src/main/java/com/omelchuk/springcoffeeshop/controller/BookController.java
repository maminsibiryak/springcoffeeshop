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

    @RequestMapping("/bookmanager/book/{id}")
    public String book(@PathVariable Long id, Model model){
        model.addAttribute("book", bookRepository.findOne(id));
        return "bookmanager/book";
    }
    @RequestMapping(value = "/bookmanager/books",method = RequestMethod.GET)
    public String bookList(Model model){
        model.addAttribute("books", bookRepository.findAll());
        return "bookmanager/books";
    }
    @RequestMapping(value = "/bookmanager/all",method = RequestMethod.GET)
    public String all(Model model){
        model.addAttribute("books", bookRepository.findAll());
        return "bookmanager/all";
    }

    @RequestMapping(value = "/bookmanager/savebook", method = RequestMethod.POST)
    @ResponseBody
    public String saveBook(@RequestBody Book book) {
        bookRepository.save(book);
        return String.valueOf(book.getBookId());
    }


}
