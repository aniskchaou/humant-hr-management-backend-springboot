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

import com.dev.delta.entities.Warning;
import com.dev.delta.services.WarningService;



@RestController
@RequestMapping("/warning")
@CrossOrigin
public class WarningController {
	@Autowired
	WarningService warningService;

	@PostMapping("/create")
	public ResponseEntity<?> addPTToBoard(@Validated @RequestBody Warning projectWarning, BindingResult result) {

		if (result.hasErrors()) {
			Map<String, String> errorMap = new HashMap<String, String>();

			for (FieldError error : result.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		}

		Warning newPT = warningService.save(projectWarning);

		return new ResponseEntity<Warning>(newPT, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public Iterable<Warning> getAllWarnings() {
		return warningService.getWarnings();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Warning> getWarningById(@PathVariable Long id) {
		Warning warning = warningService.findById(id);
		return new ResponseEntity<Warning>(warning, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteWarning(@PathVariable Long id) {
		warningService.delete(id);
		return new ResponseEntity<String>("warning was deleted", HttpStatus.OK);
	}
}
