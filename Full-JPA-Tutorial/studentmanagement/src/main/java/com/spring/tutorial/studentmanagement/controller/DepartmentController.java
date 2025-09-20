package com.spring.tutorial.studentmanagement.controller;

import com.spring.tutorial.studentmanagement.entity.Department;
import com.spring.tutorial.studentmanagement.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    @GetMapping
    public List<Department> getDepartments(){
        return departmentService.findAll();
    }

}
