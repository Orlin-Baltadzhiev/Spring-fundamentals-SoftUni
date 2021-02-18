package com.andreys.service;

import com.andreys.model.entities.Category;
import com.andreys.model.entities.enums.CategoryName;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {
    void initCategories();

    Category findByName(CategoryName category);
}
