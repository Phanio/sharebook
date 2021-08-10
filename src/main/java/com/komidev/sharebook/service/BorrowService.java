package com.komidev.sharebook.service;

import com.komidev.sharebook.entity.Borrow;
import com.komidev.sharebook.repository.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BorrowService {
    private Long userId = 1L;
    @Autowired
    private BorrowRepository borrowRepository;

    public List<Borrow> getMyBorrows(){
      return  borrowRepository.findByBorrowerId(userId);
    }
}
