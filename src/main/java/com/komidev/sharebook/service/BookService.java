package com.komidev.sharebook.service;

import com.komidev.sharebook.entity.Book;
import com.komidev.sharebook.repository.BookRepository;
import com.komidev.sharebook.utils.BookStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    private Long userId =1L;

    public List<Book> getBooks(BookStatus bookStatus){
        List<Book> books;
        if(bookStatus !=null && bookStatus == BookStatus.FREE){
            books = bookRepository.findByStatusAndUserIdNotAndDeletedFalse(bookStatus, userId);
        }else{
            books = bookRepository.findByUserIdAndDeletedFalse(userId);
        }
        return books;
    }

    public Book getBook(Long id){
        return bookRepository.findById(id).get();
    }

    public Book create(Book book) {
        return bookRepository.save(book);
    }

    public Book edit(Book book) {
        return bookRepository.save(book);
    }

    public Boolean delete(Long id) {
        try {
            bookRepository.deleteById(id);
            return Boolean.TRUE;
        }catch (Exception ex){
            ex.printStackTrace();
            return Boolean.FALSE;
        }
    }
}
