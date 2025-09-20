package com.spring.tutorial.studentmanagement;

import com.spring.tutorial.studentmanagement.entity.Course;
import com.spring.tutorial.studentmanagement.entity.Department;
import com.spring.tutorial.studentmanagement.entity.Student;
import com.spring.tutorial.studentmanagement.repository.CourseRepository;
import com.spring.tutorial.studentmanagement.repository.DepartmentRepository;
import com.spring.tutorial.studentmanagement.repository.StudentRepository;
import com.spring.tutorial.studentmanagement.service.CourseService;
import com.spring.tutorial.studentmanagement.service.DepartmentService;
import com.spring.tutorial.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class StudentmanagementApplication  {

	public static void main(String[] args) {
        SpringApplication.run(StudentmanagementApplication.class, args);
	}

}
