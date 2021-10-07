package com.dev.delta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.delta.entities.Leave;

public interface LeaveRepository extends JpaRepository<Leave, Long> {

}
