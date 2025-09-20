package com.spring.tutorial.studentmanagement.dto;

import jakarta.validation.constraints.*;

public class CreateStudentDto {
    @NotNull
    private String name;
    @Email
    private String email;
    @Min(15)@Max(25)
    private int age;
    @NotNull
    @Size(min = 8)
    private String password;


    public CreateStudentDto(){

    }

    public CreateStudentDto(String name, String email, int age, String password) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.password = password;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
