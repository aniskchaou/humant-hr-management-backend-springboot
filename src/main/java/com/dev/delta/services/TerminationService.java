package com.dev.delta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Termination;
import com.dev.delta.repositories.TerminationRepository;
@Service
public class TerminationService {
	/**
	 * terminationRepository
	 */
	@Autowired
	private TerminationRepository terminationRepository;

	/**
	 * getTerminations
	 * 
	 * @return
	 */
	public List<Termination> getTerminations() {
		return terminationRepository.findAll();
	}

	/**
	 * getCount
	 * 
	 * @return
	 */
	public long getCount() {
		return terminationRepository.count();
	}

	/**
	 * save
	 * 
	 * @param termination
	 */
	public Termination save(Termination termination) {
		return terminationRepository.save(termination);
	}

	/**
	 * findById
	 * 
	 * @param id
	 * @return
	 */
	public Termination findById(Long id) {
		return terminationRepository.findById(id).orElseThrow();
	}

	/**
	 * delete
	 * 
	 * @param id
	 */
	public void delete(Long id) {
		terminationRepository.delete(terminationRepository.findById(id).get());
	}
}
