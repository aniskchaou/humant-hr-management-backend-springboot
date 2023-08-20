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

import com.dev.delta.entities.Training;
import com.dev.delta.services.TraningService;



@RestController
@RequestMapping("/training")
@CrossOrigin
public class TrainingController {
	@Autowired
	TraningService trainingService;

	@PostMapping("/create")
	public ResponseEntity<?> addPTToBoard(@Validated @RequestBody Training projectTraining, BindingResult result) {

		if (result.hasErrors()) {
			Map<String, String> errorMap = new HashMap<String, String>();

			for (FieldError error : result.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		}

		Training newPT = trainingService.save(projectTraining);

		return new ResponseEntity<Training>(newPT, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public Iterable<Training> getAllTrainings() {
		return trainingService.getTrainings();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Training> getTrainingById(@PathVariable Long id) {
		Training training = trainingService.findById(id);
		return new ResponseEntity<Training>(training, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteTraining(@PathVariable Long id) {
		trainingService.delete(id);
		//return new ResponseEntity<String>("training was deleted", HttpStatus.OK);
	}
}
