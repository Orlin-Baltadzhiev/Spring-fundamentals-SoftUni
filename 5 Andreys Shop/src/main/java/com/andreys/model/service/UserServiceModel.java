package com.andreys.model.service;

import java.math.BigDecimal;

public class UserServiceModel {

    private String id;
    private String username;
    private String password;
    private String email;
    private BigDecimal Budget;

    public UserServiceModel() {
    }

    public String getId() {
        return id;
    }

    public UserServiceModel setId(String id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public BigDecimal getBudget() {
        return Budget;
    }

    public UserServiceModel setBudget(BigDecimal budget) {
        Budget = budget;
        return this;
    }
}
