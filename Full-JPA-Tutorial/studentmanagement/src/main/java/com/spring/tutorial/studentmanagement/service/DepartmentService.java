package com.spring.tutorial.studentmanagement.service;

import com.spring.tutorial.studentmanagement.entity.Department;
import com.spring.tutorial.studentmanagement.entity.Student;
import com.spring.tutorial.studentmanagement.repository.DepartmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    public void save(Department department){
        departmentRepository.save(department);
    }

    public List<Department> findAll(){
        return departmentRepository.findAll();
    }
}
