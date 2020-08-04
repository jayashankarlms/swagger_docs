package com.development.swagger;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.development.swagger.entity.Employee;
import com.development.swagger.repository.EmployeeRepository;

@SpringBootApplication
public class SwaggerApplication implements CommandLineRunner{

	@Autowired
	private EmployeeRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(SwaggerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Employee e1 = new Employee(1,"jay","java");
		Employee e2 = new Employee(2,"shankar","sql");
		Employee e3 = new Employee(3,"aditya","ML");
		List<Employee> list = Arrays.asList(e1,e2,e3);
		repo.saveAll(list);
		list.forEach(value->repo.save(value));
	}
	
}
