package com.cognizant.countryquery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.countryquery.model.Department;
import com.cognizant.countryquery.repository.DepartmentRepository;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department get(int id) {
        return departmentRepository.findById(id).get();
    }

    public void save(Department department) {
        departmentRepository.save(department);
    }
}