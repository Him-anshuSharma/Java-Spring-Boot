package com.spring.tutorial.studentmanagement.service;

import com.spring.tutorial.studentmanagement.entity.Student;
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

}
