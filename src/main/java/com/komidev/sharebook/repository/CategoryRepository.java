package com.komidev.sharebook.repository;

import com.komidev.sharebook.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
