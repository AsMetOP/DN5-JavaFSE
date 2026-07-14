package com.cognizant.employeemanagementsystem.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cognizant.employeemanagementsystem.model.Employee;
import com.cognizant.employeemanagementsystem.projection.EmployeeNameOnly;
import com.cognizant.employeemanagementsystem.projection.EmployeeSummary;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByDepartmentId(Long departmentId);

    List<Employee> findByNameContaining(String name);

    @Query("SELECT e FROM Employee e WHERE e.email = :email")
    Employee findByEmailCustom(@Param("email") String email);

    List<Employee> findByDepartment_NameOrderByNameAsc(String departmentName);

    List<Employee> findAllOrderedByName();

    Page<Employee> findByNameContainingIgnoreCase(String name, Pageable pageable);

    List<EmployeeNameOnly> findByDepartmentIdNot(Long departmentId);

    @Query("SELECT new com.cognizant.employeemanagementsystem.projection.EmployeeSummary(e.name, e.department.name) FROM Employee e")
    List<EmployeeSummary> getEmployeeSummaries();

}