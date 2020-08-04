package com.development.swagger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.development.swagger.entity.Employee;
import com.development.swagger.repository.EmployeeRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/employee-management")
public class SwaggerController {

	@Autowired
	private EmployeeRepository repo;
	
	@GetMapping("/employees")
	@ApiOperation(value="get all employee",
				  notes="fetch all employee from the employee table",
				  response=Employee.class)
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}
	
	@GetMapping("/employees/employee")
	public Employee getEmployee(@ApiParam(value="employee id") @RequestParam("employeeId") int employeeId) {
		return repo.findById(employeeId).orElse(new Employee());
	}
	
	@PostMapping("/employees")
	public Employee saveEmployee(@ApiParam(value="employee details") @ModelAttribute Employee employee) {
		return repo.save(employee);
	}
	
	@PutMapping("/employees/employee")
	public Employee updateEmployee(@ModelAttribute Employee employee) {
		Employee updatedEmployee = new Employee();
		if(repo.existsById(employee.getEmpId())) {
			updatedEmployee = repo.save(employee);
		}
		return updatedEmployee;
	}
	
	@DeleteMapping("/employees/employee")
	public Employee deleteEmployee(@RequestParam("employeeId") int employeeId) {
		Employee deletedEmployee = repo.findById(employeeId).orElse(new Employee());
		if(deletedEmployee.getEmpId() != 0) {
			repo.deleteById(employeeId);
		}
		return deletedEmployee;
	}
}
