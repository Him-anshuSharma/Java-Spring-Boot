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
public class StudentmanagementApplication implements CommandLineRunner {

	public static void main(String[] args) {
        SpringApplication.run(StudentmanagementApplication.class, args);
	}

    @Autowired
    private CourseService courseService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private StudentService studentService;

    private final Scanner sc = new Scanner(System.in);

    @Override
    public void run(String... args) {
        seedCourses();
        seedDepartments();
        runCLI();
    }

    // ----------------------------
    // Seed Data
    // ----------------------------
    private void seedCourses() {
        List<String> courses = Arrays.asList("Maths", "Biology", "Computer Science", "Finance");
        for (String c : courses) {
            try {
                courseService.save(new Course(c));
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    private void seedDepartments() {
        List<String> departments = Arrays.asList("PCM", "PCB", "Commerce");
        for (String d : departments) {
            try {
                departmentService.save(new Department(d));
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    // ----------------------------
    // CLI
    // ----------------------------
    private void runCLI() {
        while (true) {
            System.out.println("\n--- Student CLI ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewAllStudents();
                case 3 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }
    // ----------------------------
    // CLI Functions
    // ----------------------------
    private void addStudent() {
        // Name
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter student email: ");
        String email = sc.nextLine();

        System.out.print("Enter student age: ");
        int age = sc.nextInt();
        sc.nextLine();


        // Pick Department
        Department dept = chooseDepartment();

        // Pick Courses
        List<Course> selectedCourses = chooseCourses();

        // Save Student
        Student student = new Student(name,email,age);
        selectedCourses.forEach(student::addCourse);
        student.setDepartment(dept);
        studentService.save(student);

        System.out.println("✅ Student saved: " + student.getName());
    }

    private void viewAllStudents() {
        System.out.println("\n--- All Students ---");
        studentService.findAllWithCourses().forEach(s ->
                System.out.println(s.getId() + " | " + s.getName() + " | Dept: " +
                        s.getDepartment().getDepartmentName() + " | Courses: " +
                        s.getCourses().stream().map(Course::getCourseName).toList() + " | Email: " + s.getEmail().toLowerCase())
        );
    }

    // ----------------------------
    // Helpers
    // ----------------------------
    private Department chooseDepartment() {
        List<Department> deptList = departmentService.findAll();
        System.out.println("Available Departments:");
        for (int i = 0; i < deptList.size(); i++) {
            System.out.println((i + 1) + ". " + deptList.get(i).getDepartmentName());
        }
        System.out.print("Choose department number: ");
        int deptIndex = sc.nextInt() - 1;
        sc.nextLine();
        return deptList.get(deptIndex);
    }

    private List<Course> chooseCourses() {
        List<Course> allCourses = courseService.findAll();
        List<Course> selectedCourses = new ArrayList<>();

        System.out.println("Available Courses (enter numbers separated by space):");
        for (int i = 0; i < allCourses.size(); i++) {
            System.out.println((i + 1) + ". " + allCourses.get(i).getCourseName());
        }

        String[] courseChoices = sc.nextLine().split(" ");
        for (String cIndex : courseChoices) {
            int idx = Integer.parseInt(cIndex) - 1;
            selectedCourses.add(allCourses.get(idx));
        }

        return selectedCourses;
    }

}
