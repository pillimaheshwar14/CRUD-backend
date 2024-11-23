package com.spring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.EmployeeDTO;
import com.spring.service.EmployeeService;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	private EmployeeService empService;
	
	// Build Add Employee REST API
	@PostMapping
	public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
		EmployeeDTO savedEmployee = empService.createEmployee(employeeDTO);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}
	
	// Build GET Employee REST API
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long eid) {
		EmployeeDTO employee = empService.getEmpById(eid);
		
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	// Build GET All Employees REST API 
	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> getEmployees() {
		List<EmployeeDTO> allEmployees = empService.getAllEmployees();
		return new ResponseEntity<>(allEmployees, HttpStatus.OK);
	}
	
	// Build UPDATE Employee REST API
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id")  Long id, @RequestBody EmployeeDTO employee) {
		EmployeeDTO updateEmployee = empService.updateEmployee(id, employee);
		
		return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
	}
	
	// Build DELETE Employee REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
		empService.deleteEmployee(id);
		return new ResponseEntity<>("Employee deleted sucessfully...", HttpStatus.OK);
	}
	
	
	
	
	
	
	
}
