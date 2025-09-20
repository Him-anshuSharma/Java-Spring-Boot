package com.spring.tutorial.studentmanagement.controller;

import com.spring.tutorial.studentmanagement.dto.CreateStudentDto;
import com.spring.tutorial.studentmanagement.dto.LoginRequestDto;
import com.spring.tutorial.studentmanagement.dto.ResponseDto;
import com.spring.tutorial.studentmanagement.entity.Admin;
import com.spring.tutorial.studentmanagement.entity.Course;
import com.spring.tutorial.studentmanagement.entity.Department;
import com.spring.tutorial.studentmanagement.entity.Student;
import com.spring.tutorial.studentmanagement.service.AdminService;
import com.spring.tutorial.studentmanagement.service.CourseService;
import com.spring.tutorial.studentmanagement.service.DepartmentService;
import com.spring.tutorial.studentmanagement.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/login")
    public ResponseDto<Admin> getAdmin(@Valid @RequestBody LoginRequestDto request){
        Optional<Admin> admin = adminService.verifyAdmin(request.getUsername(),request.getPassword());
        if(admin.isPresent()){
            return new ResponseDto<Admin>(
                    HttpStatus.OK,
                    "Verified",
                    admin.get()
            );
        }
        else{
            return new ResponseDto<Admin>(
                    HttpStatus.NOT_FOUND,
                    "wrong credentials",
                    null
            );
        }
    }

    @PostMapping("/create-student")
    public ResponseDto<Student> createStudent(@Valid @RequestBody CreateStudentDto request){
        Optional<Student> student = studentService.save(new Student(
                request.getName(),request.getEmail(), request.getAge(), request.getPassword()
        ));

        if(student.isPresent()){
            return new ResponseDto<Student>(
                    HttpStatus.CREATED,
                    "Created Student",
                    student.get()
            );
        }
        else{
            return new ResponseDto< >(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Student already exists!",
                    null
            );
        }
    }


    @PostMapping("/add-course/{courseName}")
    public ResponseDto<Course> addCourse(@PathVariable String courseName){
        Optional<Course> course = courseService.save(new Course(courseName));
        return course
                .map(value ->
                        new ResponseDto<>(
                            HttpStatus.CREATED,
                            "Course Created",
                            value))
                .orElseGet(() ->
                        new ResponseDto<>(
                            HttpStatus.INTERNAL_SERVER_ERROR,
                            "Course with same name already exists",
                            null)
                );
    }

    @PostMapping("/add-department/{deptName}")
    public ResponseDto<Department> addDepartment(@PathVariable String deptName){
        Optional<Department> department = departmentService.save(new Department(deptName));
        return department
                .map(value ->
                        new ResponseDto<>(
                                HttpStatus.CREATED,
                                "Created",
                                value))
                .orElseGet(() -> new ResponseDto<>(
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        "Department Already Exist!",
                        null));
    }

    @PostMapping("/delete-student/{id}")
    public ResponseDto<String> deleteStudent(@PathVariable int id) {
        if(studentService.deleteStudent(id)){
            return new ResponseDto<String>(HttpStatus.OK,"Deleted","Student Deleted Succesfully");
        }
        else return new ResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR,"Student Does not exist","Recheck Id");
    }

}
