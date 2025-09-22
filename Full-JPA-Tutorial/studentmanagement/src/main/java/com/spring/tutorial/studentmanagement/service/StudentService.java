package com.spring.tutorial.studentmanagement.service;

import com.spring.tutorial.studentmanagement.dto.StudentRequestDto;
import com.spring.tutorial.studentmanagement.entity.Course;
import com.spring.tutorial.studentmanagement.entity.Department;
import com.spring.tutorial.studentmanagement.entity.Student;
import com.spring.tutorial.studentmanagement.repository.CourseRepository;
import com.spring.tutorial.studentmanagement.repository.DepartmentRepository;
import com.spring.tutorial.studentmanagement.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    CourseRepository courseRepository;

    public Optional<Student> verifyStudent(String email,String password){
        return studentRepository.findByEmailAndPassword(email, password);
    }

    public Optional<Student> save(Student student){
        Optional<Student> result = studentRepository.findByEmail(student.getEmail());
        if(result.isPresent()){
            return Optional.empty();
        }
        return Optional.of(studentRepository.save(student));
    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public List<Student> findAllWithCourses(){
        List<Student> studentList = studentRepository.findAll();
        for(Student student: studentList)student.getCourses().size();
        return studentList;
    }

    public Optional<Student> findStudentWithId(int id){
        return studentRepository.findById(id);
    }

    public boolean deleteStudent(int id){
        Optional<Student> student = studentRepository.findById(id);
        if(student.isEmpty()) return false;
        studentRepository.delete(student.get());
        return true;
    }

    public Optional<Student> updateStudent(StudentRequestDto student){
        Optional<Student> result = studentRepository.findById(student.getId());
        if(result.isPresent()){
            Student newStudent = result.get();
            newStudent.setName(student.getName());
            newStudent.setAge(student.getAge());
            newStudent.setEmail(student.getEmail());
            if(newStudent.getDepartment()== null || student.getDepartmentId() != newStudent.getDepartment().getId()){
                Optional<Department> department = departmentRepository.findById(student.getDepartmentId());
                department.ifPresent(newStudent::setDepartment);
            }
            if(student.getCourses() != null){
                newStudent.getCourses().clear();
                for (int courseId : student.getCourses()) {
                    Optional<Course> course = courseRepository.findById(courseId);
                    course.ifPresent(value -> newStudent.getCourses().add(value));
                }
            }
            return Optional.of(studentRepository.save(newStudent));
        }
        return Optional.empty();
    }
}
