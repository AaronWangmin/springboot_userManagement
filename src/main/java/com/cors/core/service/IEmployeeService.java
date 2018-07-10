package com.cors.core.service;


import java.util.List;

import com.cors.core.entity.Employee;

public interface IEmployeeService {
	public Employee add(Employee employee);
	public Employee add(Employee employee, int orgnizationId);
	public void delete(int id);
	public void update(Employee employee);
	public List<Employee> findAll();
	public Employee findById(int id);
	public List<Employee> findByName(String name);

}
