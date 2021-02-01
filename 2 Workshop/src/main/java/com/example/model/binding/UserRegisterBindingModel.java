package com.example.model.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserRegisterBindingModel {

    @Length(min = 2, message = "Username length must be minimum two characters!")
    @NotNull
    private String username;

    @Length(min = 3, message = "Username length must be minimum two characters!")
    @NotNull
    private String password;


    private String confirmPassword;

    @Email(message = "Enter valid email address")
    @NotNull
    private String email;

    @Pattern(regexp = "https:\\/\\/github\\.com.+",
    message = "Enter a valid git address")
    @NotNull
    private String git;

    public UserRegisterBindingModel() {
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGit() {
        return git;
    }

    public void setGit(String git) {
        this.git = git;
    }
}