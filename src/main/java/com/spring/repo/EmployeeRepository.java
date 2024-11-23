package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
