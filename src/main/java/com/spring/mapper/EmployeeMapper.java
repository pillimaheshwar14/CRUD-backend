package com.spring.mapper;

import com.spring.dto.EmployeeDTO;
import com.spring.entity.Employee;

public class EmployeeMapper {
	public static EmployeeDTO mapToEmlpoyeeDTO(Employee emp) {
		return new EmployeeDTO(emp.getId(), emp.getFirstName(), emp.getLastName(), emp.getEmail());
	}
	
	public static Employee mapToEmployee(EmployeeDTO employeeDTO) {
		return new Employee(employeeDTO.getId(), employeeDTO.getFirstName(), employeeDTO.getLastName(), employeeDTO.getEmail());
		
	}
}
