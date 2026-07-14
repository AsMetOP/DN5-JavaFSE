package com.cognizant.springlearn.dao;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.springlearn.Employee;

@Repository
public class EmployeeDao {

	private static ArrayList<Employee> EMPLOYEE_LIST;

	@SuppressWarnings("unchecked")
	public EmployeeDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		EMPLOYEE_LIST = (ArrayList<Employee>) context.getBean("employeeList");
	}

	public ArrayList<Employee> getAllEmployees() {
		return EMPLOYEE_LIST;
	}

}