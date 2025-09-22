package com.spring.tutorial.studentmanagement.dto;

import jakarta.validation.constraints.*;

import java.util.List;

public class StudentRequestDto {
    private Integer id; // optional for create, required for update
    @NotNull
    private String name;
    @Email
    private String email;
    @Min(15) @Max(25)
    private int age;
    @NotNull
    @Size(min = 8)
    private String password;
    private List<Integer> courses;   // optional for create
    private Integer departmentId;

    public StudentRequestDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<Integer> getCourses() {
        return courses;
    }

    public void setCourses(List<Integer> courses) {
        this.courses = courses;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
}