package com.cors.core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cors.core.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	public List<Employee> findByName(String name);

}
