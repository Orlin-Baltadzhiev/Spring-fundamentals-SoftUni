package com.andreys.model.binding;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class UserRegisterBindingModel {

    private String username;
    private String password;
    private String confirmPassword;
    private String email;
    private BigDecimal Budget;

    public UserRegisterBindingModel() {
    }

    @NotBlank(message = "Username cannot be  empty string")
    @Size(min = 2, message = "Username length must be more than two charachters")
    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }
    @NotBlank(message = "Password cannot be  empty string")
    @Size(min = 3, message = "Password length must be more than two charachters")
    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    @Email(message = "Must be valid")
    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    @DecimalMin(value = "0", message = "Budget must be positive number")
    public BigDecimal getBudget() {
        return Budget;
    }

    public UserRegisterBindingModel setBudget(BigDecimal budget) {
        Budget = budget;
        return this;
    }
    @NotBlank(message = "Password cannot be  empty string")
    @Size(min = 3, message = "Password length must be more than two charachters")
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
