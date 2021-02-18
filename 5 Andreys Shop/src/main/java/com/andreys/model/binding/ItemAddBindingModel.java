package com.andreys.model.binding;

import com.andreys.model.entities.Category;
import com.andreys.model.entities.enums.CategoryName;
import com.andreys.model.entities.enums.Gender;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class ItemAddBindingModel {

    private String name;
    private String description;
    private BigDecimal price;
    private CategoryName category;
    private Gender gender;

    public ItemAddBindingModel() {
    }

    @Size(min = 2, message ="Username must be more than two characters")
    @NotBlank(message = "Name cannot be empty String")
    public String getName() {
        return name;
    }

    public ItemAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @Size(min = 3, message ="Description must be more than two characters")
    @NotBlank(message = "Description cannot be empty String")
    public String getDescription() {
        return description;
    }

    public ItemAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    @DecimalMin(value = "0", message = "Price must be positive number")
    public BigDecimal getPrice() {
        return price;
    }

    public ItemAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
    @NotNull(message = "You must select category")
    public CategoryName getCategory() {
        return category;
    }

    public ItemAddBindingModel setCategory(CategoryName category) {
        this.category = category;
        return this;
    }

    @NotNull(message = "You must select category")
    public Gender getGender() {
        return gender;
    }

    public ItemAddBindingModel setGender(Gender gender) {
        this.gender = gender;
        return this;
    }
}
