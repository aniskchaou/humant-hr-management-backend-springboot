package com.dev.delta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Announcement;
import com.dev.delta.repositories.AnnouncementRepository;
@Service
public class AnnoucementService {
	/**
	 * announcementRepository
	 */
	@Autowired
	private AnnouncementRepository announcementRepository;

	/**
	 * getAnnouncements
	 * 
	 * @return
	 */
	public List<Announcement> getAnnouncements() {
		return announcementRepository.findAll();
	}

	/**
	 * getCount
	 * 
	 * @return
	 */
	public long getCount() {
		return announcementRepository.count();
	}

	/**
	 * save
	 * 
	 * @param announcement
	 */
	public Announcement save(Announcement announcement) {
		return announcementRepository.save(announcement);
	}

	/**
	 * findById
	 * 
	 * @param id
	 * @return
	 */
	public Announcement findById(Long id) {
		return announcementRepository.findById(id).orElseThrow();
	}

	/**
	 * delete
	 * 
	 * @param id
	 */
	public void delete(Long id) {
		announcementRepository.delete(announcementRepository.findById(id).get());
	}
}
