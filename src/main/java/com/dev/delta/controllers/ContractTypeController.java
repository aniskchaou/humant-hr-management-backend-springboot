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

import com.dev.delta.entities.ContractType;
import com.dev.delta.services.ContractTypeService;

@RestController
@RequestMapping("/contracttype")
@CrossOrigin
public class ContractTypeController {
	@Autowired
	ContractTypeService contractService;

	@PostMapping("/create")
	public ResponseEntity<?> addPTToBoard(@Validated @RequestBody ContractType projectContractType, BindingResult result) {

		if (result.hasErrors()) {
			Map<String, String> errorMap = new HashMap<String, String>();

			for (FieldError error : result.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		}

		ContractType newPT = contractService.save(projectContractType);

		return new ResponseEntity<ContractType>(newPT, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public Iterable<ContractType> getAllContractTypes() {
		return contractService.getContractTypes();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ContractType> getContractTypeById(@PathVariable Long id) {
		ContractType contract = contractService.findById(id);
		return new ResponseEntity<ContractType>(contract, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteContractType(@PathVariable Long id) {
		contractService.delete(id);
		
	}
}
