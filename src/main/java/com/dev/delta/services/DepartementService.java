package com.dev.delta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Departement;
import com.dev.delta.repositories.DepartementRepository;
@Service
public class DepartementService {
	/**
	 * departementRepository
	 */
	@Autowired
	private DepartementRepository departementRepository;

	/**
	 * getDepartements
	 * 
	 * @return
	 */
	public List<Departement> getDepartements() {
		return departementRepository.findAll();
	}

	/**
	 * getCount
	 * 
	 * @return
	 */
	public long getCount() {
		return departementRepository.count();
	}

	/**
	 * save
	 * 
	 * @param departement
	 */
	public Departement save(Departement departement) {
		return departementRepository.save(departement);
	}

	/**
	 * findById
	 * 
	 * @param id
	 * @return
	 */
	public Departement findById(Long id) {
		return departementRepository.findById(id).orElseThrow();
	}

	/**
	 * delete
	 * 
	 * @param id
	 */
	public void delete(Long id) {
		departementRepository.delete(departementRepository.findById(id).get());
	}
}
