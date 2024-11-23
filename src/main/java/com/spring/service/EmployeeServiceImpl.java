package com.spring.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring.dto.EmployeeDTO;
import com.spring.entity.Employee;
import com.spring.exception.NoEmployeeFoundException;
import com.spring.mapper.EmployeeMapper;
import com.spring.repo.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository empRepo;

	@Override
	public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
		Employee e1 = EmployeeMapper.mapToEmployee(employeeDTO);
		Employee savedEmployee =  empRepo.save(e1);
		return EmployeeMapper.mapToEmlpoyeeDTO(savedEmployee);
	}

	@Override
	public EmployeeDTO getEmpById(Long id) {
		Employee employee = empRepo.findById(id)
				 .orElseThrow(() -> new NoEmployeeFoundException("Invalid Employee Id.."));
		return EmployeeMapper.mapToEmlpoyeeDTO(employee);
	}
	
	@Override
	public List<EmployeeDTO> getAllEmployees() {
		List<Employee> emps = empRepo.findAll();
		return emps.stream().map((emp) -> EmployeeMapper.mapToEmlpoyeeDTO(emp)).collect(Collectors.toList());
	}

	@Override
	public EmployeeDTO updateEmployee(Long id, EmployeeDTO updatedEmployee) {
		Employee emp = empRepo.findById(id)
				.orElseThrow(() -> new NoEmployeeFoundException("No Employee found with the given id: "+id));
		emp.setFirstName(updatedEmployee.getFirstName());
		emp.setLastName(updatedEmployee.getLastName());
		emp.setEmail(updatedEmployee.getEmail());
		Employee updated = empRepo.save(emp);
		return EmployeeMapper.mapToEmlpoyeeDTO(updated);
	}

	@Override
	public void deleteEmployee(Long id) {
		Employee employee = empRepo.findById(id)
				 .orElseThrow(() -> new NoEmployeeFoundException("Invalid Employee Id.."));
		empRepo.deleteById(id);
	}

}
