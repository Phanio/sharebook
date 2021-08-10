package com.komidev.sharebook.controller;

import com.komidev.sharebook.entity.Book;
import com.komidev.sharebook.service.BookService;
import com.komidev.sharebook.utils.BookStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public ResponseEntity getBooks(@RequestParam(required = false) BookStatus bookStatus){
       List<Book> books = bookService.getBooks(bookStatus);
       return ResponseEntity.ok().body(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity getBook(@PathVariable Long id){
        return ResponseEntity.ok().body(bookService.getBook(id));
    }

    @PostMapping
    public ResponseEntity addBook(@RequestBody @Valid Book book){
        return ResponseEntity.ok().body(bookService.create(book));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable Long id, @RequestBody  Book book){
        return ResponseEntity.ok().body(bookService.edit(book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return ResponseEntity.ok().body(bookService.delete(id));
    }

}
