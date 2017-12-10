package com.omelchuk.springcoffeeshop.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class StudentBookOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "STUDENT_BOOKS", joinColumns = {@JoinColumn(name = "ORDER_ID")}, inverseJoinColumns = {@JoinColumn(name = "BOOK_ID")})
    private Set<Book> books;

    @OneToOne
    private Student student;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
