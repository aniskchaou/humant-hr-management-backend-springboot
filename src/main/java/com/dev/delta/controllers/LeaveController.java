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

import com.dev.delta.entities.Leave;
import com.dev.delta.services.LeaveService;


@RestController
@RequestMapping("/leave")
@CrossOrigin
public class LeaveController {
	@Autowired
	LeaveService leaveService;

	@PostMapping("/create")
	public ResponseEntity<?> addPTToBoard(@Validated @RequestBody Leave projectLeave, BindingResult result) {

		if (result.hasErrors()) {
			Map<String, String> errorMap = new HashMap<String, String>();

			for (FieldError error : result.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		}

		Leave newPT = leaveService.save(projectLeave);

		return new ResponseEntity<Leave>(newPT, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public Iterable<Leave> getAllLeaves() {
		return leaveService.getLeaves();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Leave> getLeaveById(@PathVariable Long id) {
		Leave leave = leaveService.findById(id);
		return new ResponseEntity<Leave>(leave, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteLeave(@PathVariable Long id) {
		leaveService.delete(id);
		return new ResponseEntity<String>("leave was deleted", HttpStatus.OK);
	}
}
