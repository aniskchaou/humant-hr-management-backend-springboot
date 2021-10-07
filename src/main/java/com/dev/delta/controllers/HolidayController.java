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

import com.dev.delta.entities.Holiday;
import com.dev.delta.services.HolidayService;


@RestController
@RequestMapping("/holiday")
@CrossOrigin
public class HolidayController {
	@Autowired
	HolidayService holidayService;

	@PostMapping("/create")
	public ResponseEntity<?> addPTToBoard(@Validated @RequestBody Holiday projectHoliday, BindingResult result) {

		if (result.hasErrors()) {
			Map<String, String> errorMap = new HashMap<String, String>();

			for (FieldError error : result.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		}

		Holiday newPT = holidayService.save(projectHoliday);

		return new ResponseEntity<Holiday>(newPT, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public Iterable<Holiday> getAllHolidays() {
		return holidayService.getHolidays();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Holiday> getHolidayById(@PathVariable Long id) {
		Holiday holiday = holidayService.findById(id);
		return new ResponseEntity<Holiday>(holiday, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteHoliday(@PathVariable Long id) {
		holidayService.delete(id);
		return new ResponseEntity<String>("holiday was deleted", HttpStatus.OK);
	}
}
