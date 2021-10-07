package com.dev.delta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.User;
import com.dev.delta.repositories.UserRepository;
@Service
public class UserService {
	/**
	 * userRepository
	 */
	@Autowired
	private UserRepository userRepository;

	/**
	 * getUsers
	 * 
	 * @return
	 */
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	/**
	 * getCount
	 * 
	 * @return
	 */
	public long getCount() {
		return userRepository.count();
	}

	/**
	 * save
	 * 
	 * @param user
	 */
	public User save(User user) {
		return userRepository.save(user);
	}

	/**
	 * findById
	 * 
	 * @param id
	 * @return
	 */
	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow();
	}

	/**
	 * delete
	 * 
	 * @param id
	 */
	public void delete(Long id) {
		userRepository.delete(userRepository.findById(id).get());
	}
}
