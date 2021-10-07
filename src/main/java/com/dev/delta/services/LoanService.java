package com.dev.delta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Loan;
import com.dev.delta.repositories.LoanRepository;
@Service
public class LoanService {
	/**
	 * loanRepository
	 */
	@Autowired
	private LoanRepository loanRepository;

	/**
	 * getLoans
	 * 
	 * @return
	 */
	public List<Loan> getLoans() {
		return loanRepository.findAll();
	}

	/**
	 * getCount
	 * 
	 * @return
	 */
	public long getCount() {
		return loanRepository.count();
	}

	/**
	 * save
	 * 
	 * @param loan
	 */
	public Loan save(Loan loan) {
	  return	loanRepository.save(loan);
	}

	/**
	 * findById
	 * 
	 * @param id
	 * @return
	 */
	public Loan findById(Long id) {
		return loanRepository.findById(id).orElseThrow();
	}

	/**
	 * delete
	 * 
	 * @param id
	 */
	public void delete(Long id) {
		loanRepository.delete(loanRepository.findById(id).get());
	}
}
