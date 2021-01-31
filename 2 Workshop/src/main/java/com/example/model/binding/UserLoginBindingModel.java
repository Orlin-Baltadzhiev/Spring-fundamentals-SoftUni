package com.example.model.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class UserLoginBindingModel {

    @Length(min = 2, message = "Username length must be minimum two characters!")
    @NotNull
    private String username;

    @Length(min = 3, message = "Username length must be minimum two characters!")
    @NotNull
    private String password;

    public UserLoginBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
