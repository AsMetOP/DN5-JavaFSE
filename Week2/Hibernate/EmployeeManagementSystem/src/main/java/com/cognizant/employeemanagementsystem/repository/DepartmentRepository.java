package com.cognizant.employeemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.employeemanagementsystem.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findByName(String name);

}