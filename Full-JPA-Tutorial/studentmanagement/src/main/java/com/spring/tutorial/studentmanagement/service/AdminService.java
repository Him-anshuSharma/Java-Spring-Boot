package com.spring.tutorial.studentmanagement.service;

import com.spring.tutorial.studentmanagement.entity.Admin;
import com.spring.tutorial.studentmanagement.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Optional<Admin> verifyAdmin(String email, String password){
        return adminRepository.findByEmailAndPassword(email,password);
    }


    public Admin addUser(Admin admin){
        Optional<Admin> adminResponse = adminRepository.findByEmailAndPassword(admin.getEmail(), admin.getPassword());
        return adminResponse.orElseGet(() -> adminRepository.save(admin));
    }
}