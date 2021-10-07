package com.dev.delta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.TypeAward;
import com.dev.delta.repositories.TypeAwardRepository;
@Service
public class TypeAwardService {
	/**
	 * typeAwardRepository
	 */
	@Autowired
	private TypeAwardRepository typeAwardRepository;

	/**
	 * getTypeAwards
	 * 
	 * @return
	 */
	public List<TypeAward> getTypeAwards() {
		return typeAwardRepository.findAll();
	}

	/**
	 * getCount
	 * 
	 * @return
	 */
	public long getCount() {
		return typeAwardRepository.count();
	}

	/**
	 * save
	 * 
	 * @param typeAward
	 */
	public TypeAward save(TypeAward typeAward) {
		return typeAwardRepository.save(typeAward);
	}

	/**
	 * findById
	 * 
	 * @param id
	 * @return
	 */
	public TypeAward findById(Long id) {
		return typeAwardRepository.findById(id).orElseThrow();
	}

	/**
	 * delete
	 * 
	 * @param id
	 */
	public void delete(Long id) {
		typeAwardRepository.delete(typeAwardRepository.findById(id).get());
	}
}
