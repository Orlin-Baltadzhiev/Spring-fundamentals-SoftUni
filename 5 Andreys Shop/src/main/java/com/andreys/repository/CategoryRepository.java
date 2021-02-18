package com.andreys.repository;

import com.andreys.model.entities.Category;
import com.andreys.model.entities.enums.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository  extends JpaRepository <Category, String> {

    Optional<Category> findAllByCategoryName(CategoryName categoryName);

//    @Query("SELECT c FROM Category c WHERE c.categoryName= :categoryName ")
    Optional<Category> findByCategoryName(CategoryName categoryName);
}
