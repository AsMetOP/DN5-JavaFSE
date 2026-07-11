package com.cognizant.countryquery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.countryquery.model.Employee;
import com.cognizant.countryquery.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee get(int id) {
        return employeeRepository.findById(id).get();
    }

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }
}