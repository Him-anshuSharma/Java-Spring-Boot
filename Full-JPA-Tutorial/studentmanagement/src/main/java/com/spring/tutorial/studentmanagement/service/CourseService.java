package com.spring.tutorial.studentmanagement.service;

import com.spring.tutorial.studentmanagement.entity.Course;
import com.spring.tutorial.studentmanagement.repository.CourseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    public Optional<Course> save(Course course){

        Optional<Course> courseOptional = courseRepository.findBycourseNameIgnoreCase(course.getCourseName());
        if(courseOptional.isPresent()){
            return Optional.empty();
        }
        else return Optional.of(courseRepository.save(course));
    }

    public List<Course> findAll(){
        return courseRepository.findAll();
    }
}
