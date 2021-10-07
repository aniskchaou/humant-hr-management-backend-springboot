package com.dev.delta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Award;
import com.dev.delta.repositories.AwardRepository;
@Service
public class AwardService {
	/**
	 * awardRepository
	 */
	@Autowired
	private AwardRepository awardRepository;

	/**
	 * getAwards
	 * 
	 * @return
	 */
	public List<Award> getAwards() {
		return awardRepository.findAll();
	}

	/**
	 * getCount
	 * 
	 * @return
	 */
	public long getCount() {
		return awardRepository.count();
	}

	/**
	 * save
	 * 
	 * @param award
	 * @return 
	 */
	public Award save(Award award) {
		return awardRepository.save(award);
	}

	/**
	 * findById
	 * 
	 * @param id
	 * @return
	 */
	public Award findById(Long id) {
		return awardRepository.findById(id).orElseThrow();
	}

	/**
	 * delete
	 * 
	 * @param id
	 */
	public void delete(Long id) {
		awardRepository.delete(awardRepository.findById(id).get());
	}
}
