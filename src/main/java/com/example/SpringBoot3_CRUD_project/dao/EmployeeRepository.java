package com.example.SpringBoot3_CRUD_project.dao;

import com.example.SpringBoot3_CRUD_project.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// that's it ... no need to write any code LOL!
	
}
