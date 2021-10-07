package com.dev.delta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Contract;
import com.dev.delta.repositories.ContractRepository;
@Service
public class ContractService {

	/**
	 * contractRepository
	 */
	@Autowired
	private ContractRepository contractRepository;

	/**
	 * getCitys
	 * 
	 * @return
	 */
	public List<Contract> getCitys() {
		return contractRepository.findAll();
	}

	/**
	 * getCount
	 * 
	 * @return
	 */
	public long getCount() {
		return contractRepository.count();
	}

	/**
	 * save
	 * 
	 * @param projectContract
	 * @return 
	 */
	public Contract save(Contract projectContract) {
		return contractRepository.save(projectContract);
	}

	/**
	 * findById
	 * 
	 * @param id
	 * @return
	 */
	public Contract findById(Long id) {
		return contractRepository.findById(id).orElseThrow();
	}

	/**
	 * delete
	 * 
	 * @param id
	 */
	public void delete(Long id) {
		contractRepository.delete(contractRepository.findById(id).get());
	}
}
