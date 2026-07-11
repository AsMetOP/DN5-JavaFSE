package com.cognizant.countryquery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.countryquery.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}