package com.komidev.sharebook.controller;

import com.komidev.sharebook.entity.Borrow;
import com.komidev.sharebook.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/borrow")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;
    public ResponseEntity getMyBorrows(){
        List<Borrow> borrows = borrowService.getMyBorrows();
        return ResponseEntity.ok().body(borrows);
    }
}
