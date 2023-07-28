package com.example.SpringBoot3_CRUD_project.controller;

import com.example.SpringBoot3_CRUD_project.entity.Employee;
import com.example.SpringBoot3_CRUD_project.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		List<Employee> employeeList = employeeService.findAll();
		theModel.addAttribute("employees", employeeList);
		return "list-employees";
	}
}









