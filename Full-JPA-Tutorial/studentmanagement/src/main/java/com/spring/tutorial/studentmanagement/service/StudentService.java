package com.spring.tutorial.studentmanagement.service;

import com.spring.tutorial.studentmanagement.entity.Student;
import com.spring.tutorial.studentmanagement.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void save(Student student){
        studentRepository.save(student);
    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public List<Student> findAllWithCourses(){
        List<Student> studentList = studentRepository.findAll();
        for(Student student: studentList)student.getCourses().size();
        return studentList;
    }

}
