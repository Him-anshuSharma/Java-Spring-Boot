package com.spring.tutorial.studentmanagement.controller;

import com.spring.tutorial.studentmanagement.entity.Student;
import com.spring.tutorial.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;


    @GetMapping
    List<Student> getStudents(){
       return studentService.findAllWithCourses();

    }

    @GetMapping("/{id}")
    Student getStudentById(@PathVariable("id") int id){
        Optional<Student> student = studentService.findStudentWithId(id);
        return student.get();
    }

}
