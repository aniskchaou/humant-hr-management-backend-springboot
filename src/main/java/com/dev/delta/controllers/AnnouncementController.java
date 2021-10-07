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

import com.dev.delta.entities.Announcement;
import com.dev.delta.services.AnnoucementService;


@RestController
@RequestMapping("/announcement")
@CrossOrigin
public class AnnouncementController {
	@Autowired
	AnnoucementService announcementService;

	@PostMapping("/create")
	public ResponseEntity<?> addPTToBoard(@Validated @RequestBody Announcement projectAnnouncement, BindingResult result) {

		if (result.hasErrors()) {
			Map<String, String> errorMap = new HashMap<String, String>();

			for (FieldError error : result.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		}

		Announcement newPT = announcementService.save(projectAnnouncement);

		return new ResponseEntity<Announcement>(newPT, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public Iterable<Announcement> getAllAnnouncements() {
		return announcementService.getAnnouncements();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Announcement> getAnnouncementById(@PathVariable Long id) {
		Announcement announcement = announcementService.findById(id);
		return new ResponseEntity<Announcement>(announcement, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteAnnouncement(@PathVariable Long id) {
		announcementService.delete(id);
		return new ResponseEntity<String>("announcement was deleted", HttpStatus.OK);
	}
}
