package com.dev.delta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Employee;
import com.dev.delta.repositories.EmployeeRepository;
@Service
public class EmployeeService {
	/**
	 * employeeRepository
	 */
	@Autowired
	private EmployeeRepository employeeRepository;

	/**
	 * getEmployees
	 * 
	 * @return
	 */
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	/**
	 * getCount
	 * 
	 * @return
	 */
	public long getCount() {
		return employeeRepository.count();
	}

	/**
	 * save
	 * 
	 * @param employee
	 */
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	/**
	 * findById
	 * 
	 * @param id
	 * @return
	 */
	public Employee findById(Long id) {
		return employeeRepository.findById(id).orElseThrow();
	}

	/**
	 * delete
	 * 
	 * @param id
	 */
	public void delete(Long id) {
		employeeRepository.delete(employeeRepository.findById(id).get());
	}
}
