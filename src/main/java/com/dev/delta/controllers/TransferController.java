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

import com.dev.delta.entities.Transfer;
import com.dev.delta.services.TransferService;


@RestController
@RequestMapping("/transfer")
@CrossOrigin
public class TransferController {
	@Autowired
	TransferService transferService;

	@PostMapping("/create")
	public ResponseEntity<?> addPTToBoard(@Validated @RequestBody Transfer projectTransfer, BindingResult result) {

		if (result.hasErrors()) {
			Map<String, String> errorMap = new HashMap<String, String>();

			for (FieldError error : result.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		}

		Transfer newPT = transferService.save(projectTransfer);

		return new ResponseEntity<Transfer>(newPT, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public Iterable<Transfer> getAllTransfers() {
		return transferService.getTransfers();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Transfer> getTransferById(@PathVariable Long id) {
		Transfer transfer = transferService.findById(id);
		return new ResponseEntity<Transfer>(transfer, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteTransfer(@PathVariable Long id) {
		transferService.delete(id);
		return new ResponseEntity<String>("transfer was deleted", HttpStatus.OK);
	}
}
