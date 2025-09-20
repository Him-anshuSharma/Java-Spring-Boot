package com.spring.tutorial.studentmanagement.controller;

import com.spring.tutorial.studentmanagement.entity.Course;
import com.spring.tutorial.studentmanagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    List<Course> getAllCourses(){
        return courseService.findAll();
    }

}