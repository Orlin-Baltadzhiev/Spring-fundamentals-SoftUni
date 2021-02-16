package com.exam.service;


import com.exam.model.entities.Category;
import com.exam.model.entities.enums.CategoryName;

public interface CategoryService {
    void initCategories();

    Category findByName(CategoryName categoryName);
}
