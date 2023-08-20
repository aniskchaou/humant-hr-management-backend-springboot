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

import com.dev.delta.entities.City;
import com.dev.delta.services.CityService;
@RestController
@RequestMapping("/city")
@CrossOrigin
public class CityController {
	@Autowired
	CityService cityService;

	@PostMapping("/create")
	public ResponseEntity<?> addPTToBoard(@Validated @RequestBody City projectCity, BindingResult result) {

		if (result.hasErrors()) {
			Map<String, String> errorMap = new HashMap<String, String>();

			for (FieldError error : result.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		}

		City newPT = cityService.save(projectCity);

		return new ResponseEntity<City>(newPT, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public Iterable<City> getAllCitys() {
		return cityService.getCitys();
	}

	@GetMapping("/{id}")
	public ResponseEntity<City> getCityById(@PathVariable Long id) {
		City city = cityService.findById(id);
		return new ResponseEntity<City>(city, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteCity(@PathVariable Long id) {
		cityService.delete(id);
		//return new ResponseEntity<String>("city was deleted", HttpStatus.OK);
	}
}
