package com.spring.tutorial.studentmanagement.dto;

import com.spring.tutorial.studentmanagement.entity.Department;

public class DepartmentDto {
    private int id;
    private String departmentName;

    public DepartmentDto() {
    }

    public DepartmentDto(int id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    static public DepartmentDto fromDepartment(Department department){
        return new DepartmentDto(
                department.getId(),
                department.getDepartmentName()
        );
    }

}
