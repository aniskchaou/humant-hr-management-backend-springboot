package com.dev.delta.services;

import com.dev.delta.entities.Salary;
import com.dev.delta.repositories.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryService {
	/**
	 * SalaryRepository
	 */
	@Autowired
	private SalaryRepository SalaryRepository;

	/**
	 * getSalarys
	 * 
	 * @return
	 */
	public List<Salary> getSalarys() {
		return SalaryRepository.findAll();
	}

	/**
	 * getCount
	 * 
	 * @return
	 */
	public long getCount() {
		return SalaryRepository.count();
	}

	/**
	 * save
	 * 
	 * @param Salary
	 */
	public Salary save(Salary Salary) {
		return SalaryRepository.save(Salary);
	}

	/**
	 * findById
	 * 
	 * @param id
	 * @return
	 */
	public Salary findById(Long id) {
		return SalaryRepository.findById(id).orElseThrow();
	}

	/**
	 * delete
	 * 
	 * @param id
	 */
	public void delete(Long id) {
		SalaryRepository.delete(SalaryRepository.findById(id).get());
	}
}
