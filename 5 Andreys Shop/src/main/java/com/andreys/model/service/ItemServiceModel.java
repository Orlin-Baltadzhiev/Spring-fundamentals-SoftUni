package com.andreys.model.service;

import com.andreys.model.entities.Category;
import com.andreys.model.entities.enums.Gender;

import java.math.BigDecimal;

public class ItemServiceModel {

    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private Category category;
    private Gender gender;

    public ItemServiceModel() {
    }

    public String getId() {
        return id;
    }

    public ItemServiceModel setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ItemServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ItemServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public ItemServiceModel setCategory(Category category) {
        this.category = category;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public ItemServiceModel setGender(Gender gender) {
        this.gender = gender;
        return this;
    }
}
