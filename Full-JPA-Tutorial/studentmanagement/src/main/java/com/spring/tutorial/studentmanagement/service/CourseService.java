package com.spring.tutorial.studentmanagement.service;

import com.spring.tutorial.studentmanagement.entity.Course;
import com.spring.tutorial.studentmanagement.repository.CourseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    public void save(Course course){
        courseRepository.save(course);
    }

    public List<Course> findAll(){
        return courseRepository.findAll();
    }
}
