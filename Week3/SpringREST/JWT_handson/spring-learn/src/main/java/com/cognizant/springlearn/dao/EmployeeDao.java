package com.cognizant.springlearn.dao;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

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

	public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
		for (int i = 0; i < EMPLOYEE_LIST.size(); i++) {
			if (EMPLOYEE_LIST.get(i).getId().equals(employee.getId())) {
				EMPLOYEE_LIST.set(i, employee);
				return;
			}
		}
		throw new EmployeeNotFoundException("Employee not found");
	}

	public void deleteEmployee(Integer id) throws EmployeeNotFoundException {
		for (int i = 0; i < EMPLOYEE_LIST.size(); i++) {
			if (EMPLOYEE_LIST.get(i).getId().equals(id)) {
				EMPLOYEE_LIST.remove(i);
				return;
			}
		}
		throw new EmployeeNotFoundException("Employee not found");
	}

}