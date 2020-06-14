package com.cognizant.springlearn.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.service.EmployeeNotFoundException;
import com.cognizant.springlearn.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@PostMapping
	public void updateEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException {

		EmployeeService es = new EmployeeService();
		es.updateEmployee(employee);
	}
	
	@GetMapping
	public ArrayList<Employee> getAllEmployees() {
		
		return EmployeeService.getAllEmployees();
	}
	
	@DeleteMapping
	public void deleteEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException {

		EmployeeService es = new EmployeeService();
		es.deleteEmployee(employee);
	}

}
