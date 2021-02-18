package com.andreys.service.impl;

import com.andreys.model.entities.Category;
import com.andreys.model.entities.enums.CategoryName;
import com.andreys.repository.CategoryRepository;
import com.andreys.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {

        if(categoryRepository.count()==0){

            Arrays.stream(CategoryName.values())
                    .forEach(categoryName -> {
                        Category category = new Category(categoryName, "Description for " + categoryName.name());
                        categoryRepository.save(category);
                    });
        }

    }

    @Override
    public Category findByName(CategoryName categoryName) {
        return categoryRepository.findByCategoryName(categoryName).orElse(null);
    }
}
