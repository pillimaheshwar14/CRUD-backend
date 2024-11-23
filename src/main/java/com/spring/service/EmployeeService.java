package com.spring.service;

import java.util.List;

import com.spring.dto.EmployeeDTO;

public interface EmployeeService {
	EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
	
	EmployeeDTO getEmpById(Long id);
	
	List<EmployeeDTO> getAllEmployees();
	
	EmployeeDTO updateEmployee(Long id, EmployeeDTO updatedEmployee);
	
	void deleteEmployee(Long id);
}
