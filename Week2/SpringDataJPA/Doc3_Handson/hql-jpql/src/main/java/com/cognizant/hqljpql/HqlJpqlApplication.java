package com.cognizant.hqljpql;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.hqljpql.model.Employee;
import com.cognizant.hqljpql.service.EmployeeService;

@SpringBootApplication
public class HqlJpqlApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(HqlJpqlApplication.class);

    private static EmployeeService employeeService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(HqlJpqlApplication.class, args);
        employeeService = context.getBean(EmployeeService.class);

        testGetAllPermanentEmployees();
    }

    private static void testGetAllPermanentEmployees() {
        LOGGER.info("Start");
        List<Employee> employees = employeeService.getAllPermanentEmployees();
        LOGGER.debug("Permanent Employees:{}", employees);
        employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));
        LOGGER.info("End");
    }
}