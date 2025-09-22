package com.spring.tutorial.studentmanagement.dto;

import com.spring.tutorial.studentmanagement.entity.Student;

import java.util.List;

public class StudentResponseDto {
    private Integer id;
    private String name;
    private String email;
    private int age;
    private DepartmentDto department;
    private List<CourseDto> courses;


    public StudentResponseDto() {
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

    public DepartmentDto getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDto department) {
        this.department = department;
    }

    public List<CourseDto> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseDto> courses) {
        this.courses = courses;
    }

    public static StudentResponseDto fromStudent(Student student){
        StudentResponseDto studentResponseDto = new StudentResponseDto();

        studentResponseDto.setId(student.getId());
        studentResponseDto.setAge(student.getId());
        studentResponseDto.setDepartment(DepartmentDto.fromDepartment(student.getDepartment()));
        studentResponseDto.setCourses(CourseDto.fromCourse(student.getCourses()));

        return studentResponseDto;

    }

}
