package com.spring.tutorial.studentmanagement.dto;

import com.spring.tutorial.studentmanagement.entity.Course;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CourseDto {
    @NotNull
    private int id;
    @NotNull
    private String courseName;

    public CourseDto() {
    }

    public CourseDto(int id, String courseName) {
        this.id = id;
        this.courseName = courseName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public static List<CourseDto> fromCourse(List<Course> courses){
        List<CourseDto> courseDtoList = new ArrayList<>();

        for(Course course : courses){
            courseDtoList.add(
                    new CourseDto(course.getId(),course.getCourseName())
            );
        }
        return courseDtoList;

    }

    public static CourseDto fromCourse(Course course){
        return new CourseDto(course.getId(),course.getCourseName());
    }

}
