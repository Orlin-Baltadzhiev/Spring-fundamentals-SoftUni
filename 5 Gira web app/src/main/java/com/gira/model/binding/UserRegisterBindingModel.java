package com.gira.model.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserRegisterBindingModel {

    private String username;
    private String password;
    private String confirmPassword;
    private String email;

    public UserRegisterBindingModel() {
    }

    @NotBlank(message = "Username cannot be empty string!")
    @Size(min = 3,max = 20,message ="Username must be between 3 and 20 charachters")
    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }
    @NotBlank(message = "Password cannot be empty string!")
    @Size(min = 3,max = 20,message ="Password must be between 3 and 20 charachters")
    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
    @NotBlank(message = "Password cannot be empty string!")
    @Size(min = 3,max = 20,message ="Password must be between 3 and 20 charachters")
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
    @Email(message = "Email must be valid!")
    @NotEmpty(message = "Email cannot be empty")
    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }
}
