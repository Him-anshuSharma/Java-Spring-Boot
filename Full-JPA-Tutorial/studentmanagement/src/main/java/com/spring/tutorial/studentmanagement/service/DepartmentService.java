package com.spring.tutorial.studentmanagement.service;

import com.spring.tutorial.studentmanagement.entity.Department;
import com.spring.tutorial.studentmanagement.entity.Student;
import com.spring.tutorial.studentmanagement.repository.DepartmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    public Optional<Department> save(Department department){
        if(departmentRepository.findBydepartmentName(department.getDepartmentName()).isPresent())return Optional.empty();
        else return Optional.of(departmentRepository.save(department));
    }

    public List<Department> findAll(){
        return departmentRepository.findAll();
    }
}
