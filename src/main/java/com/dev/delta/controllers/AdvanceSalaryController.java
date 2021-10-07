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

import com.dev.delta.entities.AdvanceSalary;
import com.dev.delta.services.AdvanceSalaryService;

@RestController
@RequestMapping("/advanceSalary")
@CrossOrigin
public class AdvanceSalaryController {
	@Autowired
	AdvanceSalaryService advanceSalaryService;

	@PostMapping("/create")
	public ResponseEntity<?> addPTToBoard(@Validated @RequestBody AdvanceSalary projectAdvanceSalary, BindingResult result) {

		if (result.hasErrors()) {
			Map<String, String> errorMap = new HashMap<String, String>();

			for (FieldError error : result.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		}

		AdvanceSalary newPT = advanceSalaryService.save(projectAdvanceSalary);

		return new ResponseEntity<AdvanceSalary>(newPT, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public Iterable<AdvanceSalary> getAllAdvanceSalarys() {
		return advanceSalaryService.getAdvanceSalarys();
	}

	@GetMapping("/{id}")
	public ResponseEntity<AdvanceSalary> getAdvanceSalaryById(@PathVariable Long id) {
		AdvanceSalary advanceSalary = advanceSalaryService.findById(id);
		return new ResponseEntity<AdvanceSalary>(advanceSalary, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteAdvanceSalary(@PathVariable Long id) {
		advanceSalaryService.delete(id);
		return new ResponseEntity<String>("advanceSalary was deleted", HttpStatus.OK);
	}
}
