package com.dev.delta.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.delta.entities.Contract;
import com.dev.delta.services.ContractService;


@RestController
@RequestMapping("/contract")
@CrossOrigin
public class ContractController {
	@Autowired
	ContractService contractService;

	@PostMapping("/create")
	public ResponseEntity<?> addPTToBoard(@Validated @RequestBody Contract projectContract, BindingResult result) {

		if (result.hasErrors()) {
			Map<String, String> errorMap = new HashMap<String, String>();

			for (FieldError error : result.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		}

		Contract newPT = contractService.save(projectContract);

		return new ResponseEntity<Contract>(newPT, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public Iterable<Contract> getAllContracts() {
		return contractService.getCitys();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Contract> getContractById(@PathVariable Long id) {
		Contract contract = contractService.findById(id);
		return new ResponseEntity<Contract>(contract, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteContract(@PathVariable Long id) {
		contractService.delete(id);
		return new ResponseEntity<String>("contract was deleted", HttpStatus.OK);
	}
}
