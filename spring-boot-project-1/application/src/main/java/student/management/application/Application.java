package student.management.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import student.management.application.entity.Student;
import student.management.application.service.StudentService;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		StudentService studentService = context.getBean(StudentService.class);

//        List<Student> students = new ArrayList<>();
//
//        // Creating students
//        Student s1 = new Student("Alice", "alice@example.com", 20);
//        Student s2 = new Student("Bob", "bob@example.com", 22);
//        Student s3 = new Student("Alice", "alice2@example.com", 19); // Same name as s1
//        Student s4 = new Student("Charlie", "charlie@example.com", 23);
//
//        // Adding to the list
//        students.add(s1);
//        students.add(s2);
//        students.add(s3);
//        students.add(s4);
//
//        for(Student student: students){
//            studentService.saveStudent(student);
//        }

        List<Student> students = studentService.getAllStudents();
        students.forEach(System.out::println);

	}

}
