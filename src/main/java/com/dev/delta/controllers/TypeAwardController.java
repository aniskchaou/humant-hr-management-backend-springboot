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

import com.dev.delta.entities.TypeAward;
import com.dev.delta.services.TypeAwardService;



@RestController
@RequestMapping("/typeaward")
@CrossOrigin
public class TypeAwardController {
	@Autowired
	TypeAwardService typeAwrdService;

	@PostMapping("/create")
	public ResponseEntity<?> addPTToBoard(@Validated @RequestBody TypeAward projectTypeAward, BindingResult result) {

		if (result.hasErrors()) {
			Map<String, String> errorMap = new HashMap<String, String>();

			for (FieldError error : result.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		}

		TypeAward newPT = typeAwrdService.save(projectTypeAward);

		return new ResponseEntity<TypeAward>(newPT, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public Iterable<TypeAward> getAllTypeAwards() {
		return typeAwrdService.getTypeAwards();
	}

	@GetMapping("/{id}")
	public ResponseEntity<TypeAward> getTypeAwardById(@PathVariable Long id) {
		TypeAward typeAwrd = typeAwrdService.findById(id);
		return new ResponseEntity<TypeAward>(typeAwrd, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteTypeAward(@PathVariable Long id) {
		typeAwrdService.delete(id);
		//return "deleted";
	}
}
