package com.dev.delta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.delta.entities.Holiday;

public interface HolidayRepository extends JpaRepository<Holiday, Long> {

}
