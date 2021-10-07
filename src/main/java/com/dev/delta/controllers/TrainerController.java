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

import com.dev.delta.entities.Trainer;
import com.dev.delta.services.TrainerService;


@RestController
@RequestMapping("/trainer")
@CrossOrigin
public class TrainerController {
	@Autowired
	TrainerService trainerService;

	@PostMapping("/create")
	public ResponseEntity<?> addPTToBoard(@Validated @RequestBody Trainer projectTrainer, BindingResult result) {

		if (result.hasErrors()) {
			Map<String, String> errorMap = new HashMap<String, String>();

			for (FieldError error : result.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		}

		Trainer newPT = trainerService.save(projectTrainer);

		return new ResponseEntity<Trainer>(newPT, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public Iterable<Trainer> getAllTrainers() {
		return trainerService.getTrainers();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Trainer> getTrainerById(@PathVariable Long id) {
		Trainer trainer = trainerService.findById(id);
		return new ResponseEntity<Trainer>(trainer, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteTrainer(@PathVariable Long id) {
		trainerService.delete(id);
		return new ResponseEntity<String>("trainer was deleted", HttpStatus.OK);
	}
}
