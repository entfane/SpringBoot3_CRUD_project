package com.example.SpringBoot3_CRUD_project.service;


import com.example.SpringBoot3_CRUD_project.entity.Employee;

import java.util.List;

public interface EmployeeService {

	List<Employee> findAll();
	
	Employee findById(int theId);
	
	void save(Employee theEmployee);
	
	void deleteById(int theId);
	
}
