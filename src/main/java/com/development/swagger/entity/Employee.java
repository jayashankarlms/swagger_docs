package com.development.swagger.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="swagger_employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description="employee table is used to store employee details")
public class Employee {

	@Id
	@ApiModelProperty(value="employee id")
	private int empId;
	@ApiModelProperty(dataType="String", value="employee name")
	private String empName;
	@ApiModelProperty(dataType="String", value="employee working technology")
	private String tech;
	
}