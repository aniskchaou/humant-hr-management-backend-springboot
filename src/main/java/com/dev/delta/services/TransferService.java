package com.dev.delta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Transfer;
import com.dev.delta.repositories.TransferRepository;

@Service
public class TransferService {
	/**
	 * transferRepository
	 */
	@Autowired
	private TransferRepository transferRepository;

	/**
	 * getTransfers
	 * 
	 * @return
	 */
	public List<Transfer> getTransfers() {
		return transferRepository.findAll();
	}

	/**
	 * getCount
	 * 
	 * @return
	 */
	public long getCount() {
		return transferRepository.count();
	}

	/**
	 * save
	 * 
	 * @param transfer
	 */
	public Transfer save(Transfer transfer) {
		return transferRepository.save(transfer);
	}

	/**
	 * findById
	 * 
	 * @param id
	 * @return
	 */
	public Transfer findById(Long id) {
		return transferRepository.findById(id).orElseThrow();
	}

	/**
	 * delete
	 * 
	 * @param id
	 */
	public void delete(Long id) {
		transferRepository.delete(transferRepository.findById(id).get());
	}
}
