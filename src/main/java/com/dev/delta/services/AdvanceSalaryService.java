package com.dev.delta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.AdvanceSalary;
import com.dev.delta.repositories.AdvanceSalaryRepository;
@Service
public class AdvanceSalaryService {
	/**
	 * adavanceSalaryRepository
	 */
	@Autowired
	private AdvanceSalaryRepository adavanceSalaryRepository;

	/**
	 * getAdvanceSalarys
	 * 
	 * @return
	 */
	public List<AdvanceSalary> getAdvanceSalarys() {
		return adavanceSalaryRepository.findAll();
	}

	/**
	 * getCount
	 * 
	 * @return
	 */
	public long getCount() {
		return adavanceSalaryRepository.count();
	}

	/**
	 * save
	 * 
	 * @param adavanceSalary
	 */
	public AdvanceSalary save(AdvanceSalary adavanceSalary) {
		return adavanceSalaryRepository.save(adavanceSalary);
	}

	/**
	 * findById
	 * 
	 * @param id
	 * @return
	 */
	public AdvanceSalary findById(Long id) {
		return adavanceSalaryRepository.findById(id).orElseThrow();
	}

	/**
	 * delete
	 * 
	 * @param id
	 */
	public void delete(Long id) {
		adavanceSalaryRepository.delete(adavanceSalaryRepository.findById(id).get());
	}
}
