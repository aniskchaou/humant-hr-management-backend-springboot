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

import com.dev.delta.entities.Complain;
import com.dev.delta.services.ComplainService;
@RestController
@RequestMapping("/complain")
@CrossOrigin
public class ComplainController {
	@Autowired
	ComplainService complainService;

	@PostMapping("/create")
	public ResponseEntity<?> addPTToBoard(@Validated @RequestBody Complain projectComplain, BindingResult result) {

		if (result.hasErrors()) {
			Map<String, String> errorMap = new HashMap<String, String>();

			for (FieldError error : result.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		}

		Complain newPT = complainService.save(projectComplain);

		return new ResponseEntity<Complain>(newPT, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public Iterable<Complain> getAllComplains() {
		return complainService.getComplains();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Complain> getComplainById(@PathVariable Long id) {
		Complain complain = complainService.findById(id);
		return new ResponseEntity<Complain>(complain, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteComplain(@PathVariable Long id) {
		complainService.delete(id);
		return new ResponseEntity<String>("complain was deleted", HttpStatus.OK);
	}
}
