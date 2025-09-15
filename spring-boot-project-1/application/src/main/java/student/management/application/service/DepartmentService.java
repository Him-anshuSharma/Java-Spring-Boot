package student.management.application.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import student.management.application.entity.Department;
import student.management.application.repository.DepartmentRepository;

import java.util.List;

@Service
@Transactional
public class DepartmentService{
    @Autowired
    DepartmentRepository departmentRepository;

    public void saveDepartment(Department department){
        departmentRepository.save(department);
    }

    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }
}