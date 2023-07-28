package com.example.SpringBoot3_CRUD_project.dao;

import com.example.SpringBoot3_CRUD_project.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findAllByOrderByLastNameAsc();

}
