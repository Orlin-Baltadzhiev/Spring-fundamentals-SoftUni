package com.gira.model.entities;

import com.gira.model.entities.enums.ProgressEnum;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "task")
public class Task extends BaseEntity {
    private String name;
    private String description;
    private ProgressEnum progressEnum;
    private LocalDate dueDate;
    private Classification classification;
    private User user;

    public Task() {
    }

    @Column(name = "user", unique = true,nullable = false)
    public String getName() {
        return name;
    }

    public Task setName(String name) {
        this.name = name;
        return this;
    }

    @Column(name = "description", nullable = false,columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public Task setDescription(String description) {
        this.description = description;
        return this;
    }

    @Enumerated(EnumType.STRING)
    public ProgressEnum getProgressEnum() {
        return progressEnum;
    }

    public Task setProgressEnum(ProgressEnum progressEnum) {
        this.progressEnum = progressEnum;
        return this;
    }
    @Column(name = "due_date")
    public LocalDate getDueDate() {
        return dueDate;
    }

    public Task setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    @ManyToOne
    public Classification getClassification() {
        return classification;
    }

    public Task setClassification(Classification classification) {
        this.classification = classification;
        return this;
    }
    @ManyToOne
    public User getUser() {
        return user;
    }

    public Task setUser(User user) {
        this.user = user;
        return this;
    }
}
