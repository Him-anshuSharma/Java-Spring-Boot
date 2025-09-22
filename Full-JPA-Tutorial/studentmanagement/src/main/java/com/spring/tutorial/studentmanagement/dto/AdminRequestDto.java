package com.spring.tutorial.studentmanagement.dto;

import com.spring.tutorial.studentmanagement.entity.Admin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AdminRequestDto {
    @NotNull
    private String name;
    @Email
    private String email;
    @Size(min = 8)
    private String password;

    public AdminRequestDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public static Admin toAdmin(AdminRequestDto adminRequestDto){
        return new Admin(adminRequestDto.password,adminRequestDto.email,adminRequestDto.name);
    }

}
