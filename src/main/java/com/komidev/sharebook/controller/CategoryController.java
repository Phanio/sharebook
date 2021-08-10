package com.komidev.sharebook.controller;

import com.komidev.sharebook.entity.Category;
import com.komidev.sharebook.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public ResponseEntity getCategories(){
        Iterable<Category> categories = categoryRepository.findAll();
        return ResponseEntity.ok().body(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCategory(@PathVariable Long id){
        Category category = categoryRepository.findById(id).get();
        return ResponseEntity.ok().body(category);
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category category){
        return ResponseEntity.ok().body(categoryRepository.save(category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        categoryRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Category delete successfully!");
    }
}
