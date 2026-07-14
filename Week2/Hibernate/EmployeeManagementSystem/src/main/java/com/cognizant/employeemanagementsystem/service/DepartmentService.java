package com.cognizant.employeemanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.employeemanagementsystem.model.Department;
import com.cognizant.employeemanagementsystem.repository.DepartmentRepository;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    public Department getById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    public void delete(Long id) {
        departmentRepository.deleteById(id);
    }
}