package com.dev.delta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Leave;
import com.dev.delta.repositories.LeaveRepository;
@Service
public class LeaveService {
	/**
	 * leaveRepository
	 */
	@Autowired
	private LeaveRepository leaveRepository;

	/**
	 * getLeaves
	 * 
	 * @return
	 */
	public List<Leave> getLeaves() {
		return leaveRepository.findAll();
	}

	/**
	 * getCount
	 * 
	 * @return
	 */
	public long getCount() {
		return leaveRepository.count();
	}

	/**
	 * save
	 * 
	 * @param leave
	 * @return 
	 */
	public Leave save(Leave leave) {
		return leaveRepository.save(leave);
	}

	/**
	 * findById
	 * 
	 * @param id
	 * @return
	 */
	public Leave findById(Long id) {
		return leaveRepository.findById(id).orElseThrow();
	}

	/**
	 * delete
	 * 
	 * @param id
	 */
	public void delete(Long id) {
		leaveRepository.delete(leaveRepository.findById(id).get());
	}
}
