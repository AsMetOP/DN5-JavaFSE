package com.cognizant.hqljpql;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.hqljpql.model.Employee;
import com.cognizant.hqljpql.services.EmployeeService;

@SpringBootApplication
public class HqlJpqlApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(HqlJpqlApplication.class);

    private static EmployeeService employeeService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(HqlJpqlApplication.class, args);
        employeeService = context.getBean(EmployeeService.class);

        testGetAllPermanentEmployees();
        testGetAverageSalary();
        testGetAllEmployeesNative();
    }

    private static void testGetAllPermanentEmployees() {
        LOGGER.info("Start testGetAllPermanentEmployees");
        List<Employee> employees = employeeService.getAllPermanentEmployees();
        LOGGER.debug("Permanent Employees:{}", employees);
        employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));
        LOGGER.info("End testGetAllPermanentEmployees");
    }

    private static void testGetAverageSalary() {
        LOGGER.info("Start testGetAverageSalary");
        double overallAverage = employeeService.getAverageSalary();
        LOGGER.debug("Overall average salary:{}", overallAverage);
        double departmentAverage = employeeService.getAverageSalary(1);
        LOGGER.debug("Department 1 average salary:{}", departmentAverage);
        LOGGER.info("End testGetAverageSalary");
    }

    private static void testGetAllEmployeesNative() {
        LOGGER.info("Start testGetAllEmployeesNative");
        List<Employee> employees = employeeService.getAllEmployeesNative();
        LOGGER.debug("All Employees (native query):{}", employees);
        LOGGER.info("End testGetAllEmployeesNative");
    }
}