package com.dev.delta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.delta.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
