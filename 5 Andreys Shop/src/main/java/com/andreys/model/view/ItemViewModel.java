package com.andreys.model.view;

import com.andreys.model.entities.Category;
import com.andreys.model.entities.enums.Gender;

import java.math.BigDecimal;

public class ItemViewModel {

    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private Category category;
    private Gender gender;
    private String imgUrl;

    public ItemViewModel() {
    }

    public String getId() {
        return id;
    }

    public ItemViewModel setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ItemViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ItemViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public ItemViewModel setCategory(Category category) {
        this.category = category;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public ItemViewModel setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public ItemViewModel setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }
}
