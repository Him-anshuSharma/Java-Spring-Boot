package student.management.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import student.management.application.entity.Course;
import student.management.application.entity.Department;
import student.management.application.entity.Student;
import student.management.application.service.CourseService;
import student.management.application.service.DepartmentService;
import student.management.application.service.StudentService;

import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        StudentService studentService = context.getBean(StudentService.class);
        CourseService courseService = context.getBean(CourseService.class);
        DepartmentService departmentService = context.getBean(DepartmentService.class);

//        // ---------------------------
//        // 1️⃣ Create Departments
//        // ---------------------------
//        Department csDept = new Department("Computer Science");
//        Department phyDept = new Department("Physics");
//
//        departmentService.saveDepartment(csDept);
//        departmentService.saveDepartment(phyDept);
//
//        // ---------------------------
//        // 2️⃣ Create Courses
//        // ---------------------------
//        Course math = new Course("Mathematics");
//        Course physics = new Course("Physics");
//        Course cs = new Course("Computer Science");
//
//        courseService.saveCourse(math);
//        courseService.saveCourse(physics);
//        courseService.saveCourse(cs);
//
//        // ---------------------------
//        // 3️⃣ Create Students
//        // ---------------------------
//        Student alice = new Student("Alice", "alice@example.com", 20);
//        Student bob = new Student("Bob", "bob@example.com", 22);
//
//        // Assign Departments
//        alice.setDepartment(csDept);
//        bob.setDepartment(phyDept);
//
//        // Assign Courses
//        alice.addCourses(List.of(math, physics));
//        bob.addCourses(List.of(physics, cs));
//
//        // ---------------------------
//        // 4️⃣ Save Students
//        // ---------------------------
//        studentService.saveStudent(alice);
//        studentService.saveStudent(bob);

        // ---------------------------
        // 5️⃣ Fetch and print all students
        // ---------------------------
        studentService.getAllStudents().forEach(System.out::println);

        // ---------------------------
        // 6️⃣ Fetch and print departments with their students
        // ---------------------------
        departmentService.getAllDepartments().forEach(dept -> {
            System.out.println(dept);
            dept.getStudentList().forEach(System.out::println);
        });

        // ---------------------------
        // 7️⃣ Fetch and print courses with enrolled students
        // ---------------------------
        courseService.getAllCourses().forEach(course -> {
            System.out.println(course);
            course.getStudentList().forEach(s -> System.out.println("  Student: " + s.getName()));
        });

    }

}
