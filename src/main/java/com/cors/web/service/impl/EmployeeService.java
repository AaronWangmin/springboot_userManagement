package com.cors.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cors.web.dao.EmployeeRepository;
import com.cors.web.dao.OrgnizationRepository;
import com.cors.web.entity.Employee;
import com.cors.web.entity.Orgnization;
import com.cors.web.service.IEmployeeService;

@Service("employeeService")
public class EmployeeService implements IEmployeeService {
	
	@Resource
	private EmployeeRepository employeeRepository;
	
	@Resource
	private OrgnizationRepository orgnizationRepository;
	
	@Override
	public Employee add(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@Override
	public Employee add(Employee employee, int orgnizationId) {
		Orgnization orgnization = orgnizationRepository.findOne(orgnizationId);
		employee.setOrgnization(orgnization);
		return employeeRepository.save(employee);
	}

	@Override
	public void delete(int id) {
		employeeRepository.delete(id);
	}

	@Override
	public void update(Employee employee) {
		employeeRepository.save(employee);

	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) {
		return employeeRepository.findOne(id);
	}

	@Override
	public List<Employee> findByName(String name) {
		return employeeRepository.findByName(name);
	}

	

}
