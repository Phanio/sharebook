package com.komidev.sharebook.repository;

import com.komidev.sharebook.entity.Borrow;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BorrowRepository extends CrudRepository<Borrow, Long> {
    List<Borrow> findByBorrowerId(Long borrowId);
    List<Borrow> findByBookId(Long bookId);
}
