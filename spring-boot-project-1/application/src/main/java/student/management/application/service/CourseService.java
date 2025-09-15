package student.management.application.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import student.management.application.entity.Course;
import student.management.application.repository.CourseRepository;

import java.util.List;

@Service
@Transactional
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public void saveCourse(Course course){
        courseRepository.save(course);
    }

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }
}
