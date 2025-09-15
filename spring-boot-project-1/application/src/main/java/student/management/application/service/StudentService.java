package student.management.application.service;

import java.util.List;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import student.management.application.entity.Student;
import student.management.application.repository.StudentRepository;

@Service
@Transactional
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public void saveStudent(Student student){
        repository.save(student);
    }
    public List<Student> getStudentsByName(String name){ return repository.findAllByName(name);}
    public List<Student> getAllStudents(){return repository.findAll();}
    public List<Student> getStudentsByMinAge(int age){ return repository.findByAgeGreaterThan(age);}
    public Page<Student> getStudentsByPage(int page, int size){
        PageRequest pageable = PageRequest.of(page,size);
        return repository.findAll(pageable);
    }
    public List<Student> getSortedListOfStudents(String sortBy){
        return repository.findAll(Sort.by(sortBy));
    }



    StudentService(){

    }

}
