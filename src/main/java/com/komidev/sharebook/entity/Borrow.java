package com.komidev.sharebook.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User borrower;
    @ManyToOne
    private User lender;
    @ManyToOne
    private Book book;
    private LocalDate askDate;
    private LocalDate closed;

    public User getBorrower() {
        return borrower;
    }

    public void setBorrower(User borrower) {
        this.borrower = borrower;
    }

    public User getLender() {
        return lender;
    }

    public void setLender(User lender) {
        this.lender = lender;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getAskDate() {
        return askDate;
    }

    public void setAskDate(LocalDate askDate) {
        this.askDate = askDate;
    }

    public LocalDate getClosed() {
        return closed;
    }

    public Long getId() {
        return id;
    }

    public void setClosed(LocalDate closed) {
        this.closed = closed;
    }
}
