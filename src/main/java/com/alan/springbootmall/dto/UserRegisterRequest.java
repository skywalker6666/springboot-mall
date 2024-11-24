package com.alan.springbootmall.dto;

import jakarta.validation.constraints.NotBlank;

/**
 * @author alan9
 **/
public class UserRegisterRequest {
    @NotBlank
    private String email;
    @NotBlank
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRegisterRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserRegisterRequest() {
    }
}
