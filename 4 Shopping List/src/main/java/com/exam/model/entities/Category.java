package com.exam.model.entities;

import com.exam.model.entities.enums.CategoryName;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    private CategoryName name;
    private String description;

    public Category() {
    }

    public Category(CategoryName name, String description) {
        this.name = name;
        this.description = description;
    }

    @Enumerated(EnumType.STRING)
    public CategoryName getName() {
        return name;
    }

    public Category setName(CategoryName name) {
        this.name = name;
        return this;
    }

    @Column(name = "description", columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }
}
