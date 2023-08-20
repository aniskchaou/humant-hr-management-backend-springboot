package com.dev.delta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Training;
import com.dev.delta.repositories.TrainingRepository;
@Service
public class TraningService {
	/**
	 * trainingRepository
	 */
	@Autowired
	private TrainingRepository trainingRepository;

	/**
	 * getTrainings
	 * 
	 * @return
	 */
	public List<Training> getTrainings() {
		return trainingRepository.findAll();
	}

	/**
	 * getCount
	 * 
	 * @return
	 */
	public long getCount() {
		return trainingRepository.count();
	}

	/**
	 * save
	 * 
	 * @param training
	 */
	public Training save(Training training) {
		return trainingRepository.save(training);
	}

	/**
	 * findById
	 * 
	 * @param id
	 * @return
	 */
	public Training findById(Long id) {
		return trainingRepository.findById(id).orElseThrow();
	}

	/**
	 * delete
	 * 
	 * @param id
	 */
	public void delete(Long id) {
		trainingRepository.deleteById(id);
	}
}
