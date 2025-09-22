package com.spring.tutorial.studentmanagement.dto;

import com.spring.tutorial.studentmanagement.entity.Admin;

public class AdminResponseDto {
    private int id;
    private String name;
    private String email;

    public AdminResponseDto() {
    }

    public AdminResponseDto(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public static AdminResponseDto fromAdmin(Admin admin){
        return new AdminResponseDto(admin.getId(), admin.getName(), admin.getEmail());
    }
}
