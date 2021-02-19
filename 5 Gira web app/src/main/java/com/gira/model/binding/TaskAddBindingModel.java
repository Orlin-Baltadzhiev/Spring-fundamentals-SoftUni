package com.gira.model.binding;

import com.gira.model.entities.Classification;
import com.gira.model.entities.User;
import com.gira.model.entities.enums.ClassificationNameEnum;
import com.gira.model.service.UserServiceModel;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class TaskAddBindingModel {

    private String name;
    private String description;
    private LocalDate dueDate;
    private ClassificationNameEnum classification;
    private User user;

    public TaskAddBindingModel() {
    }

    @NotBlank(message = "Username cannot be empty string!")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 charachters")
    public String getName() {
        return name;
    }

    public TaskAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @Size(min = 5, message = "Description min length must be minimum 5 characters")
    public String getDescription() {
        return description;
    }

    public TaskAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "The date cannot be in the past")
    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskAddBindingModel setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    @NotNull(message = "Cannot be null")
    public ClassificationNameEnum getClassification() {
        return classification;
    }

    public TaskAddBindingModel setClassification(ClassificationNameEnum classification) {
        this.classification = classification;
        return this;
    }

    public User getUser() {
        return user;
    }

    public TaskAddBindingModel setUser(User user) {
        this.user = user;
        return this;
    }
}
