package com.komidev.sharebook.repository;

import com.komidev.sharebook.entity.Book;
import com.komidev.sharebook.utils.BookStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByStatusAndUserIdNotAndDeletedFalse(BookStatus bookStatus, Long userId);
    List<Book> findByUserIdAndDeletedFalse(Long userId);

}
