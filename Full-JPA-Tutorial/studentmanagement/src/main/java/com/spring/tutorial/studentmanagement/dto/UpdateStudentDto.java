package com.spring.tutorial.studentmanagement.dto;

import com.spring.tutorial.studentmanagement.entity.Student;
import jakarta.validation.constraints.*;

import java.util.List;

public class UpdateStudentDto {
    @NotNull
    private int id;
    @NotNull
    private String name;
    @Email
    private String email;
    @Min(15)@Max(25)
    private int age;
    @NotNull
    @Size(min = 8)
    private String password;
    @NotNull
    private List<Integer> courses;
    @NotNull
    private int departmentId;
    public UpdateStudentDto() {
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}
