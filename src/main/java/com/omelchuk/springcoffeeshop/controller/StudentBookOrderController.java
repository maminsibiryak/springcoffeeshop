package com.omelchuk.springcoffeeshop.controller;

import com.omelchuk.springcoffeeshop.model.Book;
import com.omelchuk.springcoffeeshop.model.CustomerOrder;
import com.omelchuk.springcoffeeshop.model.Student;
import com.omelchuk.springcoffeeshop.model.StudentBookOrder;
import com.omelchuk.springcoffeeshop.repository.BookRepository;
import com.omelchuk.springcoffeeshop.repository.StudentBookOrderRepository;
import com.omelchuk.springcoffeeshop.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashSet;
import java.util.Set;

@Controller
public class StudentBookOrderController {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentBookOrderRepository studentBookOrderRepository;

    @RequestMapping(value = "/bookmanager/createorder", method = RequestMethod.POST)
    @ResponseBody
    public String saveOrder(@RequestParam String firstName, @RequestParam String lastName, @RequestParam(value = "bookIds[]") Long[] bookIds, @RequestParam Long studentGroupId){
        Student student = new Student();

        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setStudentGroupId(studentGroupId);
        studentRepository.save(student);

        StudentBookOrder studentBookOrder = new StudentBookOrder();
        studentBookOrder.setStudent(studentRepository.findOne(student.getCustomerId()));

        Set<Book> bookSet = new HashSet<>();
        for (Long bookId: bookIds
             ) {
            bookSet.add(bookRepository.findOne(bookId));

        }
        studentBookOrder.setBooks(bookSet);

       studentBookOrderRepository.save(studentBookOrder);
        return studentBookOrder.getOrderId().toString();

    }

    @RequestMapping(value = "/bookmanager/studentbookorders", method = RequestMethod.GET)
    public String productList(Model model){
        model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("orders", studentBookOrderRepository.findAll());

        return "bookmanager/studentbookorders";
    }

    @RequestMapping(value = "/bookmanager/removeorder", method = RequestMethod.POST)
    @ResponseBody
    public String removeOrder(@RequestParam Long Id){
        studentBookOrderRepository.delete(Id);

        return Id.toString();
    }
}
