package com.spring.tutorial.studentmanagement.controller;

import com.spring.tutorial.studentmanagement.dto.LoginRequestDto;
import com.spring.tutorial.studentmanagement.dto.ResponseDto;
import com.spring.tutorial.studentmanagement.dto.StudentRequestDto;
import com.spring.tutorial.studentmanagement.dto.StudentResponseDto;
import com.spring.tutorial.studentmanagement.entity.Student;
import com.spring.tutorial.studentmanagement.service.StudentService;
import jakarta.validation.Valid;
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
    ResponseDto<StudentResponseDto> verifyStudent(@Valid @RequestBody LoginRequestDto request){
        Optional<Student> student = studentService.verifyStudent(request.getUsername(), request.getPassword());

        if(student.isPresent()){
            return new ResponseDto<StudentResponseDto>(
                    HttpStatus.OK,
                    "Verified",
                    StudentResponseDto.fromStudent(student.get())
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
    ResponseDto<StudentResponseDto> addCourse(@Valid @RequestBody StudentRequestDto request){
        Optional<Student> student = studentService.updateStudent(request);
        return student.map(value -> new ResponseDto<>(HttpStatus.OK, "Updated", StudentResponseDto.fromStudent(value))).orElseGet(() -> new ResponseDto<>(HttpStatus.INTERNAL_SERVER_ERROR, "Student not present in records", null));
    }

}
