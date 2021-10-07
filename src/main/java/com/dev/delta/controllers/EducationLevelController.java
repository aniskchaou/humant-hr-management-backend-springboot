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

import com.dev.delta.entities.EducationLevel;
import com.dev.delta.services.EducationLevelService;


@RestController
@RequestMapping("/educationLevel")
@CrossOrigin
public class EducationLevelController {
	@Autowired
	EducationLevelService educationLevelService;

	@PostMapping("/create")
	public ResponseEntity<?> addPTToBoard(@Validated @RequestBody EducationLevel projectEducationLevel, BindingResult result) {

		if (result.hasErrors()) {
			Map<String, String> errorMap = new HashMap<String, String>();

			for (FieldError error : result.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		}

		EducationLevel newPT = educationLevelService.save(projectEducationLevel);

		return new ResponseEntity<EducationLevel>(newPT, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public Iterable<EducationLevel> getAllEducationLevels() {
		return educationLevelService.getEducationLevels();
	}

	@GetMapping("/{id}")
	public ResponseEntity<EducationLevel> getEducationLevelById(@PathVariable Long id) {
		EducationLevel educationLevel = educationLevelService.findById(id);
		return new ResponseEntity<EducationLevel>(educationLevel, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEducationLevel(@PathVariable Long id) {
		educationLevelService.delete(id);
		return new ResponseEntity<String>("educationLevel was deleted", HttpStatus.OK);
	}
}
