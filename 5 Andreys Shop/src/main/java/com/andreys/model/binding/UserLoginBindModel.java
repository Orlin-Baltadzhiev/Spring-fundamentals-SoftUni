package com.andreys.model.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserLoginBindModel {
    private String username;
    private String password;


    public UserLoginBindModel() {
    }
    @NotBlank(message = "Username cannot be  empty string")
    @Size(min = 2, message = "Username length must be more than two charachters")
    public String getUsername() {
        return username;
    }

    public UserLoginBindModel setUsername(String username) {
        this.username = username;
        return this;
    }
    @NotBlank(message = "Password cannot be  empty string")
    @Size(min = 3, message = "Password length must be more than two charachters")
    public String getPassword() {
        return password;
    }

    public UserLoginBindModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
