package com.spring.tutorial.studentmanagement.repository;

import com.spring.tutorial.studentmanagement.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
    Optional<Course> findBycourseNameIgnoreCase(String name);
}
