package com.computer.shop.models;

import com.computer.shop.annotations.Email;
import com.computer.shop.annotations.Password;

public class User {
    private final String login;
    @Password(numberRequired = false)
    private final String password;
    @Email
    private final String email;

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
