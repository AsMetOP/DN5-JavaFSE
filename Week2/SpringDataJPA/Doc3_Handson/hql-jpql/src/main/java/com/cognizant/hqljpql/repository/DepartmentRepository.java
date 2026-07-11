package com.cognizant.hqljpql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.hqljpql.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}