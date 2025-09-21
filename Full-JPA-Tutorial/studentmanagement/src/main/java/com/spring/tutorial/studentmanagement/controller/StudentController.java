package com.spring.tutorial.studentmanagement.controller;

import com.spring.tutorial.studentmanagement.dto.LoginRequestDto;
import com.spring.tutorial.studentmanagement.dto.ResponseDto;
import com.spring.tutorial.studentmanagement.dto.UpdateStudentDto;
import com.spring.tutorial.studentmanagement.entity.Course;
import com.spring.tutorial.studentmanagement.entity.Student;
import com.spring.tutorial.studentmanagement.service.CourseService;
import com.spring.tutorial.studentmanagement.service.StudentService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/login")
    ResponseDto<Student> verifyStudent(@Valid @RequestBody LoginRequestDto request){
        Optional<Student> student = studentService.verifyStudent(request.getUsername(), request.getPassword());

        if(student.isPresent()){
            return new ResponseDto<Student>(
                    HttpStatus.OK,
                    "Verified",
                    student.get()
            );
        }
        else {
            return new ResponseDto<>(
                    HttpStatus.NOT_FOUND,
                    "Wrong credentials",
                    null
            );
        }

    }

    @PostMapping("/add-course")
    ResponseDto<Student> addCourse(@Valid @RequestBody UpdateStudentDto request){
        Optional<Student> student = studentService.updateStudent(request);
        return student.map(value -> new ResponseDto<>(HttpStatus.OK, "Updated", value)).orElseGet(() -> new ResponseDto<>(HttpStatus.INTERNAL_SERVER_ERROR, "Student not present in records", null));
    }

}
