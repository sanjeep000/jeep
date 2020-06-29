package com.example.vision.hr_service.model.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vision.hr_service.model.Employee;
import com.example.vision.hr_service.model.EmployeeList;

@RestController
@RequestMapping("/pro")
public class EmployeeResource {
	
	List<Employee>employees=Arrays.asList(new Employee("1","Dil","Padney"),new Employee("2","abhijeet","Maharjan"));
	
	@RequestMapping("/employee")
	public EmployeeList getAllEmployees() {
		EmployeeList employeeList= new EmployeeList();
		 employeeList.setEmployee(employees);
		return employeeList;
	}
	
	 @RequestMapping("/employee/{id}")
	 public Employee getEmployeeById(@PathVariable("id") final String id) {
		 Employee emp= employees.stream().filter(employee->id.equals(employee.getId())).findAny().orElse(null);
		 return emp;
	 }

}
