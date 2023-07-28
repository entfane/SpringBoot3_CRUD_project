package com.example.SpringBoot3_CRUD_project.controller;

import com.example.SpringBoot3_CRUD_project.entity.Employee;
import com.example.SpringBoot3_CRUD_project.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
		return "employees/list-employees";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "employees/employee-form";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.save(employee);
		return "redirect:/employees/list";
	}

	@GetMapping("showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int id,
									Model model) {
		Employee employee = employeeService.findById(id);
		model.addAttribute("employee", employee);
		return "employees/employee-form";

	}

}









