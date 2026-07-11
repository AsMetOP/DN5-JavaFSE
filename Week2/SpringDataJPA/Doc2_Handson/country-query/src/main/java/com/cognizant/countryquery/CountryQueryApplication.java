package com.cognizant.countryquery;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.countryquery.model.Department;
import com.cognizant.countryquery.model.Employee;
import com.cognizant.countryquery.repository.CountryRepository;
import com.cognizant.countryquery.repository.StockRepository;
import com.cognizant.countryquery.service.DepartmentService;
import com.cognizant.countryquery.service.EmployeeService;
import com.cognizant.countryquery.service.SkillService;

@SpringBootApplication
public class CountryQueryApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryQueryApplication.class);

    private static CountryRepository countryRepository;
    private static StockRepository stockRepository;
    private static EmployeeService employeeService;
    private static DepartmentService departmentService;
    private static SkillService skillService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(CountryQueryApplication.class, args);
        countryRepository = context.getBean(CountryRepository.class);
        stockRepository = context.getBean(StockRepository.class);
        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        skillService = context.getBean(SkillService.class);

        // testGetEmployee();
        // testAddEmployee();
        testUpdateEmployee();
    }

    private static void testGetEmployee() {
        LOGGER.info("Start testGetEmployee");
        Employee employee = employeeService.get(1);
        LOGGER.debug("Employee:{}", employee);
        LOGGER.debug("Department:{}", employee.getDepartment());
        LOGGER.info("End testGetEmployee");
    }

    private static void testAddEmployee() {
        LOGGER.info("Start testAddEmployee");
        Employee employee = new Employee();
        employee.setName("Aryan Samantray");
        employee.setSalary(60000);
        employee.setPermanent(true);
        employee.setDateOfBirth(new Date());

        Department department = departmentService.get(1);
        employee.setDepartment(department);

        employeeService.save(employee);
        LOGGER.debug("Saved Employee:{}", employee);
        LOGGER.info("End testAddEmployee");
    }

    private static void testUpdateEmployee() {
        LOGGER.info("Start testUpdateEmployee");
        Employee employee = employeeService.get(1);

        Department department = departmentService.get(2);
        employee.setDepartment(department);

        employeeService.save(employee);
        LOGGER.debug("Updated Employee:{}", employee);
        LOGGER.info("End testUpdateEmployee");
    }
}