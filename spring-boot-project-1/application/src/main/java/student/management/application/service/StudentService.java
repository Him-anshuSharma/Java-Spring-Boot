package student.management.application.service;

import java.util.List;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import student.management.application.entity.Student;
import student.management.application.repository.StudentRepository;

@Service
@Transactional
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public Student saveStudent(Student student){
        return repository.save(student);
    }
    public List<Student> getStudentsByName(String name){ return repository.findAllByName(name);}
    public List<Student> getAllStudents(){return repository.findAll();}
    public List<Student> getStudentsByMinAge(int age){ return repository.findByAgeGreaterThan(age);}

    StudentService(){

    }

}
