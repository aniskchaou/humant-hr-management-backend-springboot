package com.dev.delta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Resignation;
import com.dev.delta.repositories.ResignationRepository;
@Service
public class ResignationService {
	/**
	 * resignationRepository
	 */
	@Autowired
	private ResignationRepository resignationRepository;

	/**
	 * getResignations
	 * 
	 * @return
	 */
	public List<Resignation> getResignations() {
		return resignationRepository.findAll();
	}

	/**
	 * getCount
	 * 
	 * @return
	 */
	public long getCount() {
		return resignationRepository.count();
	}

	/**
	 * save
	 * 
	 * @param resignation
	 */
	public Resignation save(Resignation resignation) {
		return resignationRepository.save(resignation);
	}

	/**
	 * findById
	 * 
	 * @param id
	 * @return
	 */
	public Resignation findById(Long id) {
		return resignationRepository.findById(id).orElseThrow();
	}

	/**
	 * delete
	 * 
	 * @param id
	 */
	public void delete(Long id) {
		resignationRepository.deleteById(id);
	}
}
