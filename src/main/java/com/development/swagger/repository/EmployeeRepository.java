package com.development.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.development.swagger.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
