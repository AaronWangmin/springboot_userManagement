package com.cors.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cors.web.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	public List<Employee> findByName(String name);

}
