package com.cognizant.employeemanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cognizant.employeemanagementsystem.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByDepartmentId(Long departmentId);

    List<Employee> findByNameContaining(String name);

    @Query("SELECT e FROM Employee e WHERE e.email = :email")
    Employee findByEmailCustom(@Param("email") String email);

    List<Employee> findByDepartment_NameOrderByNameAsc(String departmentName);

    List<Employee> findAllOrderedByName();

}