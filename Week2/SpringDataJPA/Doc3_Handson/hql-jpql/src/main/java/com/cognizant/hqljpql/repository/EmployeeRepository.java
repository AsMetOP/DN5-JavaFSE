package com.cognizant.hqljpql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.hqljpql.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "SELECT e FROM Employee e left join fetch e.department d left join fetch e.skillList WHERE e.permanent = true")
    List<Employee> getAllPermanentEmployees();

}