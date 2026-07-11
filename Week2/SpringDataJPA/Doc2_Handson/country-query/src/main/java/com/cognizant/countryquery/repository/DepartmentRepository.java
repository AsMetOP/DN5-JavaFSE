package com.cognizant.countryquery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.countryquery.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}