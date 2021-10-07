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

import com.dev.delta.entities.Termination;
import com.dev.delta.services.TerminationService;

@RestController
@RequestMapping("/termination")
@CrossOrigin
public class TerminationController {
	@Autowired
	TerminationService terminationService;

	@PostMapping("/create")
	public ResponseEntity<?> addPTToBoard(@Validated @RequestBody Termination projectTermination, BindingResult result) {

		if (result.hasErrors()) {
			Map<String, String> errorMap = new HashMap<String, String>();

			for (FieldError error : result.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		}

		Termination newPT = terminationService.save(projectTermination);

		return new ResponseEntity<Termination>(newPT, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public Iterable<Termination> getAllTerminations() {
		return terminationService.getTerminations();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Termination> getTerminationById(@PathVariable Long id) {
		Termination termination = terminationService.findById(id);
		return new ResponseEntity<Termination>(termination, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteTermination(@PathVariable Long id) {
		terminationService.delete(id);
		return new ResponseEntity<String>("termination was deleted", HttpStatus.OK);
	}
}
