package com.dev.delta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.delta.entities.Resignation;

public interface ResignationRepository extends JpaRepository<Resignation, Long>{

}
