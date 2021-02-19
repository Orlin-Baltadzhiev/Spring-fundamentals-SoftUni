package com.gira.model.service;

import com.gira.model.entities.Classification;
import com.gira.model.entities.User;
import com.gira.model.entities.enums.ProgressEnum;

import java.time.LocalDate;

public class TaskServiceModel {

    private String id;
    private String name;
    private String description;
    private ProgressEnum progressEnum;
    private LocalDate dueDate;
    private Classification classification;
    private User user;

    public TaskServiceModel() {
    }

    public String getId() {
        return id;
    }

    public TaskServiceModel setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TaskServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TaskServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public ProgressEnum getProgressEnum() {
        return progressEnum;
    }

    public TaskServiceModel setProgressEnum(ProgressEnum progressEnum) {
        this.progressEnum = progressEnum;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskServiceModel setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public Classification getClassification() {
        return classification;
    }

    public TaskServiceModel setClassification(Classification classification) {
        this.classification = classification;
        return this;
    }

    public User getUser() {
        return user;
    }

    public TaskServiceModel setUser(User user) {
        this.user = user;
        return this;
    }
}
